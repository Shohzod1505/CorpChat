package ru.itis.kpfu.corpchat.feature.auth.presentation.signin.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface AuthSignInModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthSignInViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: AuthSignInViewModel): ViewModel
}
