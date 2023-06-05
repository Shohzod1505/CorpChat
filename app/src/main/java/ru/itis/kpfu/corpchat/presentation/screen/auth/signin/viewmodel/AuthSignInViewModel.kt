package ru.itis.kpfu.corpchat.presentation.screen.auth.signin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class AuthSignInViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val firebaseDatabase: FirebaseDatabase,
) : ViewModel() {

    private var dbReference: DatabaseReference? = null

    fun registerUser(
        email: String,
        password: String,
        type: String,
        onSuccess: (userId: String) -> Unit,
        onError: (String) -> Unit,
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null) {
                        val userId = user.uid
                        dbReference = firebaseDatabase.getReference(type).child(userId)

                        val hashMap: HashMap<String, String> = HashMap()
                        if (type == "User") {
                            hashMap["userId"] = userId
                        } else {
                            hashMap["companyId"] = userId
                        }
                        hashMap["email"] = email
                        hashMap["password"] = password

                        dbReference?.setValue(hashMap)?.addOnCompleteListener { dbTask ->
                            if (dbTask.isSuccessful) {
                                onSuccess(userId)
                            } else {
                                onError(dbTask.exception?.message ?: "Failed to create user")
                            }
                        }
                    } else {
                        onError(task.exception?.message ?: "Failed to create user")
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
