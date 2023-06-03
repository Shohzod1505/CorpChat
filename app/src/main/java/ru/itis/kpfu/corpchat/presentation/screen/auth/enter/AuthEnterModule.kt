package ru.itis.kpfu.corpchat.presentation.screen.auth.enter

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface AuthEnterModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthEnterViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: AuthEnterViewModel): ViewModel
}
