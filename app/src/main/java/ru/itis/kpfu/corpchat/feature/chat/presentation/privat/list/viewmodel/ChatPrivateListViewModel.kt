package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.database.*
import ru.itis.kpfu.corpchat.feature.auth.domain.UsersInfo
import javax.inject.Inject

class ChatPrivateListViewModel @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
) : ViewModel() {

    private var dbReference: DatabaseReference? = null

    private val _list = MutableLiveData<ArrayList<UsersInfo>>()
    val list: LiveData<ArrayList<UsersInfo>>
        get() = _list

    fun getList(
        currentUser: String,
    ) {
        dbReference = firebaseDatabase.getReference("User")

        dbReference?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val userList: ArrayList<UsersInfo> = ArrayList()
                for (snapshot in dataSnapshot.children) {
                    val user: UsersInfo = snapshot.getValue(UsersInfo::class.java)!!
                    if (currentUser != user.userid) {
                        Log.d("LOGGGGGGGGGGGGGGGG","CURRENT USER $currentUser | ${user.email}")
                        userList.add(user)
                    }
                }
                _list.value = userList
            }
            override fun onCancelled(databaseError: DatabaseError) {
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
                return ChatPrivateListViewModel(firebaseDatabase) as T
            }
        }
    }

}
