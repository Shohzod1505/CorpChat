package ru.itis.kpfu.corpchat.feature.auth.presentation.company.industry.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.HashMap
import javax.inject.Inject

class AuthCompanySignUpIndustryViewModel @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
) : ViewModel() {

    private var dbReference: DatabaseReference? = null

    fun updateCompany(
        companyId: String?,
        industry: ArrayList<String>,
    ) {
        if (companyId != null) {
            dbReference = firebaseDatabase.getReference("Company").child(companyId)
        }
        val hashMap: HashMap<String, Any> = HashMap()
        hashMap["industry"] = industry
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
                return AuthCompanySignUpIndustryViewModel(firebaseDatabase) as T
            }
        }
    }

}
