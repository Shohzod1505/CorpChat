package ru.itis.kpfu.corpchat.presentation.screen.news.info

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
