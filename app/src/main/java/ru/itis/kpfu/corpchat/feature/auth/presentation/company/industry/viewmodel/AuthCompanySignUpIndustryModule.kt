package ru.itis.kpfu.corpchat.feature.auth.presentation.company.industry.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface AuthCompanySignUpIndustryModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthCompanySignUpIndustryViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: AuthCompanySignUpIndustryViewModel): ViewModel
}
