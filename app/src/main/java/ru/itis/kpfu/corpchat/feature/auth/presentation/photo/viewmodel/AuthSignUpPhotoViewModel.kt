package ru.itis.kpfu.corpchat.feature.auth.presentation.photo.viewmodel

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class AuthSignUpPhotoViewModel @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
) : ViewModel() {

    private var dbReference: DatabaseReference? = null

    companion object {

        fun factory(
            firebaseDatabase: FirebaseDatabase
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras,
            ): T {
                return AuthSignUpPhotoViewModel(firebaseDatabase) as T
            }
        }
    }

}
