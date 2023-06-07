package ru.itis.kpfu.corpchat.feature.news.presentation.edit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.database.*
import java.util.*
import javax.inject.Inject

class NewsEditViewModel @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
): ViewModel() {

    private var dbReference: DatabaseReference? = null
    private val newsId = UUID.randomUUID().toString()

    private val _url = MutableLiveData<String>()
    val url: LiveData<String>
        get() = _url

    fun loadImage (
        imageUrl: String
    ) {
        _url.value = imageUrl
    }

    fun shareNews(
        title: String,
        text: String,
        userId: String?,
    ) {

        dbReference = firebaseDatabase.getReference("User")

        val hashMap: HashMap<String, Any> = HashMap()

        dbReference?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children) {
                    val id = ds.child("userId").getValue(String::class.java).toString()
                    val name = ds.child("name").getValue(String::class.java).toString()
                    val lastName = ds.child("lastName").getValue(String::class.java).toString()
                    if (userId == id) {
                        val image = _url.value
                        dbReference = firebaseDatabase.getReference("News").child(newsId)
                        hashMap["id"] = newsId
                        hashMap["title"] = title
                        hashMap["text"] = text
                        hashMap["image"] = image.toString()
                        hashMap["author"] = "$name $lastName"
                        hashMap["timestamp"] = ServerValue.TIMESTAMP
                        dbReference?.setValue(hashMap)
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
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
                extras: CreationExtras
            ): T {
                return NewsEditViewModel(firebaseDatabase) as T
            }
        }
    }

}
