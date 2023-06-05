package ru.itis.kpfu.corpchat.presentation.screen.auth.user.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface AuthUserSignUpNameModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthUserSignUpNameViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: AuthUserSignUpNameViewModel): ViewModel
}
