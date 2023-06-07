package ru.itis.kpfu.corpchat.feature.chat.presentation.channel.list.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface ChatChannelListModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatChannelListViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: ChatChannelListViewModel): ViewModel
}
