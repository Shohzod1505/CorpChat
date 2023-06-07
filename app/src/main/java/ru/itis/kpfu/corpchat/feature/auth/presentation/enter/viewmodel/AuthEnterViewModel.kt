package ru.itis.kpfu.corpchat.feature.auth.presentation.enter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthEnterViewModel @Inject constructor(
    private val auth: FirebaseAuth,
) : ViewModel() {

    fun checkUserSignIn(): Boolean {
        val firebaseUser = auth.currentUser
        if (firebaseUser != null) {
            return true
        }
        return false
    }

    companion object {

        fun factory(
            auth: FirebaseAuth,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras,
            ): T {
                return AuthEnterViewModel(auth) as T
            }
        }
    }

}
