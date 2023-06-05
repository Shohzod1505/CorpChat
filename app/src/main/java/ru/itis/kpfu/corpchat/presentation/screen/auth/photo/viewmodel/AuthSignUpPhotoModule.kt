package ru.itis.kpfu.corpchat.presentation.screen.auth.photo.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.corpchat.di.FeatureScope
import ru.itis.kpfu.corpchat.di.ViewModelKey

@Module
interface AuthSignUpPhotoModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthSignUpPhotoViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: AuthSignUpPhotoViewModel): ViewModel
}
