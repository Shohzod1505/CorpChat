package ru.itis.kpfu.corpchat.feature.news.presentation.feed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import ru.itis.kpfu.corpchat.feature.news.domain.NewsInfo
import java.util.*
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

    private val _list = MutableLiveData<ArrayList<NewsInfo>>()
    val list: LiveData<ArrayList<NewsInfo>>
        get() = _list

    fun getList() {
        dbReference = firebaseDatabase.getReference("News")
        val query = dbReference?.orderByChild("timestamp")?.limitToLast(15)

        query?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val newsList: ArrayList<NewsInfo> = ArrayList()
                for (snapshot in dataSnapshot.children) {
                    val news: NewsInfo = snapshot.getValue(NewsInfo::class.java)!!
                    newsList.add(news)
                    _list.value = newsList
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

    }

//    private fun dateFormat(
//
//    ) {
//        dbReference = firebaseDatabase.getReference("News").child("")
//        dbReference?.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val timestamp = snapshot.child("timestamp").value as Long
//                val date = Date(timestamp)
//                val dateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
//                val dateString = dateFormat.format(date)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Обработка ошибок
//            }
//        })
//    }


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

        fun factory(
            firebaseStorage: FirebaseStorage,
            firebaseDatabase: FirebaseDatabase,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras,
            ): T {
                return NewsFeedViewModel(firebaseStorage, firebaseDatabase) as T
            }
        }
    }

}
