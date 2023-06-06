package ru.itis.kpfu.corpchat.feature.auth.presentation.signin.viewmodel

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ru.itis.kpfu.corpchat.utils.checkEmpty
import ru.itis.kpfu.corpchat.utils.checkField
import ru.itis.kpfu.corpchat.utils.generatePassword
import javax.inject.Inject

class AuthSignInViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val firebaseDatabase: FirebaseDatabase,
) : ViewModel() {

    private var dbReference: DatabaseReference? = null

    private val _arraySignIn = MutableLiveData<Array<String>>()
    val arraySignIn: LiveData<Array<String>>
        get() = _arraySignIn

    fun signInExistAccount(
        email: String,
        password: String,
    ) {
        auth.signInWithEmailAndPassword(email, password)
    }

    fun signIn(
        email: String,
        password: String,
        type: String,
    ) {
        if (email.checkEmpty("Email is required") &&
            password.checkEmpty("Password is required")) {
            registerUser(email, password, type)
        }
    }

    private fun registerUser(
        email: String,
        password: String,
        type: String,
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null) {
                        val userId = user.uid
                        val hashMap: HashMap<String, String> = HashMap()
                        dbReference = firebaseDatabase.getReference(type).child(userId)

                        if (type == "User") {
                            hashMap["userId"] = userId
                            _arraySignIn.value = arrayOf(type, userId)

                        } else if (type == "Company") {
                            hashMap["companyCode"] = generatePassword(8)
                            hashMap["companyId"] = userId
                            _arraySignIn.value = arrayOf(type, userId)
                        }
                        hashMap["email"] = email
                        hashMap["password"] = password

                        dbReference?.setValue(hashMap)
                    }
                }
            }
    }

    companion object {

        fun factory(
            auth: FirebaseAuth,
            firebaseDatabase: FirebaseDatabase,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras,
            ): T {
                return AuthSignInViewModel(auth, firebaseDatabase) as T
            }
        }
    }

}
