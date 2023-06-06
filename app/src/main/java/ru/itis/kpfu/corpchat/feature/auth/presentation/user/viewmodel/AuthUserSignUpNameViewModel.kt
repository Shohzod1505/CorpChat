package ru.itis.kpfu.corpchat.feature.auth.presentation.user.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.database.*
import java.util.HashMap
import javax.inject.Inject

class AuthUserSignUpNameViewModel @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
) : ViewModel() {

    private var dbReference: DatabaseReference? = null

    fun updateUser(
        userId: String?,
        name: String,
        address: String,
        phone: String,
        company: String,
        code: String,
        onSuccess: () -> Unit,
        onFailure: () -> Unit,
    ) {
        dbReference = firebaseDatabase.getReference("Company")

        dbReference?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var isSuccess = false
                for (ds in snapshot.children) {
                    val companyName = ds.child("name").getValue(String::class.java).toString()
                    val companyCode = ds.child("companyCode").getValue(String::class.java).toString()
                    if (company == companyName && code == companyCode) {

                        if (userId != null) {
                            dbReference = firebaseDatabase.getReference("User").child(userId)
                        }

                        val hashMap: HashMap<String, Any> = HashMap()
                        hashMap["name"] = name
                        hashMap["lastName"] = address
                        hashMap["phone"] = phone
                        hashMap["company"] = company
                        dbReference?.updateChildren(hashMap)
                        isSuccess = true
                        break
                    }
                }
                if (isSuccess) {
                    onSuccess()
                } else {
                    onFailure()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                onFailure()
            }
        })
    }

    companion object {

        fun factory(
            firebaseDatabase: FirebaseDatabase,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras,
            ): T {
                return AuthUserSignUpNameViewModel(firebaseDatabase) as T
            }
        }
    }

}
