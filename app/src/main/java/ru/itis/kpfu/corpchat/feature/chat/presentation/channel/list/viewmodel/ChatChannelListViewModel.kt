package ru.itis.kpfu.corpchat.feature.chat.presentation.channel.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import javax.inject.Inject

class ChatChannelListViewModel @Inject constructor(

) : ViewModel() {


    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras,
            ): T {
                return ChatChannelListViewModel() as T
            }
        }
    }

}
