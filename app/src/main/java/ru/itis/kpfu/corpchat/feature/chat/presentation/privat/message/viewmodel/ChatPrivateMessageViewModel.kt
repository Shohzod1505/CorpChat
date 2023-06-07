package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.message.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import ru.itis.kpfu.corpchat.feature.chat.domain.MessageInfo
import java.util.*
import javax.inject.Inject

class ChatPrivateMessageViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val firebaseDatabase: FirebaseDatabase,
) : ViewModel() {

    private var dbReference: DatabaseReference? = null
    private var firebaseUser: FirebaseUser? = null
    private val messageId = UUID.randomUUID().toString()

    private val _list = MutableLiveData<ArrayList<MessageInfo>>()
    val list: LiveData<ArrayList<MessageInfo>>
        get() = _list

    fun chooseSide(
        senderId: String
    ): Boolean {
        return auth.currentUser?.email == senderId
    }

    fun sendMessage(
        senderId: String,
        receiverId: String,
        message: String,
    ) {
        dbReference = firebaseDatabase.getReference("Messages").child(messageId)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap["senderId"] = senderId
        hashMap["receiverId"] = receiverId
        hashMap["message"] = message
        dbReference?.setValue(hashMap)

    }

    fun getList(
        senderId: String,
        receiverId: String,
    ) {
        dbReference = firebaseDatabase.getReference("Message")

        dbReference?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val messageList: ArrayList<MessageInfo> = ArrayList()
                for (snapshot in dataSnapshot.children) {
                    val message: MessageInfo = snapshot.getValue(MessageInfo::class.java)!!
                    if (senderId == message.senderId && receiverId == message.receiveId) {
                        messageList.add(message)
                    }
                }
                _list.value = messageList
            }
            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

    }

    companion object {

        fun factory(
            auth: FirebaseAuth,
            firebaseDatabase: FirebaseDatabase,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras,
            ): T {
                return ChatPrivateMessageViewModel(auth, firebaseDatabase) as T
            }
        }
    }

}
