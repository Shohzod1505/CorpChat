package ru.itis.kpfu.corpchat.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(
        factory: AppViewModelFactory
    ): ViewModelProvider.Factory
}
