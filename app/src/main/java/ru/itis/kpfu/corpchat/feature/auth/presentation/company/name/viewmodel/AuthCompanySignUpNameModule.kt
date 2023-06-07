package ru.itis.kpfu.corpchat.feature.auth.presentation.company.name.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface AuthCompanySignUpNameModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthCompanySignUpNameViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: AuthCompanySignUpNameViewModel): ViewModel
}
