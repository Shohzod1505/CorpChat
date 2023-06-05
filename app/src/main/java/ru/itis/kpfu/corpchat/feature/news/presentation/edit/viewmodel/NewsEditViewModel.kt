package ru.itis.kpfu.corpchat.feature.news.presentation.edit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import ru.itis.kpfu.corpchat.feature.news.presentation.info.viewmodel.NewsInfoViewModel
import javax.inject.Inject

class NewsEditViewModel @Inject constructor(

): ViewModel() {


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
