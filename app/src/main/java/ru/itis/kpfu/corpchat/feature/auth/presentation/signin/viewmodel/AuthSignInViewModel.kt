package ru.itis.kpfu.corpchat.feature.auth.presentation.signin.viewmodel

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import ru.itis.kpfu.corpchat.utils.checkEmpty
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

    private val _companyId = MutableLiveData<String>()
    val companyId: LiveData<String>
        get() = _companyId

    private val _userId = MutableLiveData<String>()
    val userId: LiveData<String>
        get() = _userId

    fun signInExistAccount(
        email: String,
        password: String,
    ) {
        auth.signInWithEmailAndPassword(email, password)
        findId(email)
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

    private fun findId(
        email: String,
    ) {
        dbReference = firebaseDatabase.reference
        dbReference?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                searchForEmail(snapshot, email)
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun searchForEmail(snapshot: DataSnapshot, email: String) {
        for (ds in snapshot.children) {
            if (ds.child("email").getValue(String::class.java) == email) {
                if (ds.child("companyId").exists()) {
                    val companyId = ds.child("companyId").getValue(String::class.java).toString()
                    _companyId.value = companyId
                    return
                }
                if (ds.child("userId").exists()) {
                    val userId = ds.child("userId").getValue(String::class.java).toString()
                    _userId.value = userId
                    return
                }
            }
            searchForEmail(ds, email)
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
                            _arraySignIn.value = arrayOf(type, userId, email)

                        } else if (type == "Company") {
                            hashMap["companyCode"] = generatePassword(8)
                            hashMap["companyId"] = userId
                            _arraySignIn.value = arrayOf(type, userId, email)
                        }
                        hashMap["email"] = email
                        hashMap["password"] = password
                        hashMap["image"] = ""

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
