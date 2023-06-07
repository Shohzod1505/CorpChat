package ru.itis.kpfu.corpchat.feature.auth.presentation.company.name.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.HashMap
import javax.inject.Inject

class AuthCompanySignUpNameViewModel @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
) : ViewModel() {

    private var dbReference: DatabaseReference? = null

    fun updateCompany(
        companyId: String?,
        name: String,
        address: String,
        phone: String,
    ) {
        if (companyId != null) {
            dbReference = firebaseDatabase.getReference("Company").child(companyId)
        }

        val hashMap: HashMap<String, Any> = HashMap()
        hashMap["name"] = name
        hashMap["address"] = address
        hashMap["phone"] = phone
        dbReference?.updateChildren(hashMap)
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
                return AuthCompanySignUpNameViewModel(firebaseDatabase) as T
            }
        }
    }

}
