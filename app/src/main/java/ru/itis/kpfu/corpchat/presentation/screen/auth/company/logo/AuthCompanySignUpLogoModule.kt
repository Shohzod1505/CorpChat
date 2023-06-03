package ru.itis.kpfu.corpchat.presentation.screen.auth.company.logo

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface AuthCompanySignUpLogoModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthCompanySignUpLogoViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: AuthCompanySignUpLogoViewModel): ViewModel
}
