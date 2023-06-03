package ru.itis.kpfu.corpchat.presentation.screen.chat.channel.message

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface ChatChannelMessageModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatChannelMessageViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: ChatChannelMessageViewModel): ViewModel
}
