package ru.itis.kpfu.corpchat.feature.news.presentation.feed.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface NewsFeedModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsFeedViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: NewsFeedViewModel): ViewModel
}
