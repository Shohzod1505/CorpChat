package ru.itis.kpfu.corpchat.feature.news.presentation.feed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import ru.itis.kpfu.corpchat.feature.news.presentation.info.viewmodel.NewsInfoViewModel
import javax.inject.Inject

class NewsFeedViewModel @Inject constructor(
    private val firebaseStorage: FirebaseStorage,
    private val firebaseDatabase: FirebaseDatabase,
    ): ViewModel() {

    private var dbReference: DatabaseReference? = null
    private var storageRef: StorageReference? = null

    private val _url = MutableLiveData<String>()
    val url: LiveData<String>
        get() = _url

    fun findId(
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

    private fun loadImage(
        type: String,
        id: String,
    ) {
        storageRef = firebaseStorage.reference.child("$type/$id/images/ava.jpg")

        storageRef?.downloadUrl?.addOnSuccessListener { uri ->
            _url.value = uri.toString()
        }
    }

    private fun searchForEmail(snapshot: DataSnapshot, email: String) {
        for (ds in snapshot.children) {
            if (ds.child("email").getValue(String::class.java) == email) {
                if (ds.child("companyId").exists()) {
                    val companyId = ds.child("companyId").getValue(String::class.java).toString()
                    loadImage("Company", companyId)
                    return
                }
                if (ds.child("userId").exists()) {
                    val userId = ds.child("userId").getValue(String::class.java).toString()
                    loadImage("User", userId)
                    return
                }
            }
            searchForEmail(ds, email)
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return NewsInfoViewModel() as T
            }
        }
    }

}
