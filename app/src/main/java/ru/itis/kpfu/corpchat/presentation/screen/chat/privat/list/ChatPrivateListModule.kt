package ru.itis.kpfu.corpchat.presentation.screen.chat.privat.list

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface ChatPrivateListModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatPrivateListViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: ChatPrivateListViewModel): ViewModel
}
