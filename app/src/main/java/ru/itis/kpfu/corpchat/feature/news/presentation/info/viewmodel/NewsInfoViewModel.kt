package ru.itis.kpfu.corpchat.feature.news.presentation.info.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.database.*
import javax.inject.Inject

class NewsInfoViewModel @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
): ViewModel() {

    private var dbReference: DatabaseReference? = null

    private val _arrayNews = MutableLiveData<Array<String>>()
    val arrayNews: LiveData<Array<String>>
        get() = _arrayNews

    fun shareNews(
        newsId: String?,
    ) {

        dbReference = firebaseDatabase.getReference("News")

        dbReference?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children) {
                    val id = ds.child("id").getValue(String::class.java).toString()
                    val title = ds.child("title").getValue(String::class.java).toString()
                    val text = ds.child("text").getValue(String::class.java).toString()
                    val image = ds.child("image").getValue(String::class.java).toString()
                    if (newsId == id) {
                        _arrayNews.value = arrayOf(title, text, image)
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
                return NewsInfoViewModel(firebaseDatabase) as T
            }
        }
    }

}


