package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.message.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface ChatPrivateMessageModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatPrivateMessageViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: ChatPrivateMessageViewModel): ViewModel
}
