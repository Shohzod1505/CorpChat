package ru.itis.kpfu.corpchat.feature.news.presentation.info.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface NewsInfoModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsInfoViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: NewsInfoViewModel): ViewModel

}
