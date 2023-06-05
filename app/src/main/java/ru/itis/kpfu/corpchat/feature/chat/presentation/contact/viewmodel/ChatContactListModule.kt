package ru.itis.kpfu.corpchat.feature.chat.presentation.contact.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface ChatContactListModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatContactListViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: ChatContactListViewModel): ViewModel
}