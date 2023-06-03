package ru.itis.kpfu.corpchat.presentation.screen.auth.user

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface AuthUserSignUpModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthUserSignUpViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: AuthUserSignUpViewModel): ViewModel
}
