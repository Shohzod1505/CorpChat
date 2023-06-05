package ru.itis.kpfu.corpchat.presentation.screen.news.edit.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface NewsEditModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsEditViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: NewsEditViewModel): ViewModel
}
