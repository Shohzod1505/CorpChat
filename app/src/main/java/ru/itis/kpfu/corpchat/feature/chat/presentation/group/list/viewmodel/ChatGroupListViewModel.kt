package ru.itis.kpfu.corpchat.feature.chat.presentation.group.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import javax.inject.Inject

class ChatGroupListViewModel @Inject constructor(

) : ViewModel() {


    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras,
            ): T {
                return ChatGroupListViewModel() as T
            }
        }
    }

}
