package ru.itis.kpfu.corpchat.presentation.screen.chat.group.list

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface ChatGroupListModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatGroupListViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: ChatGroupListViewModel): ViewModel
}
