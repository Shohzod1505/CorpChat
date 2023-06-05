package ru.itis.kpfu.corpchat.presentation.screen.chat.group.message.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface ChatGroupMessageModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatGroupMessageViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: ChatGroupMessageViewModel): ViewModel
}
