package ru.itis.kpfu.corpchat.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import ru.itis.kpfu.corpchat.App
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        FeatureModule::class,
        AppModule::class,
        FireBaseModule::class,
    ]
)
@Singleton
interface AppComponent {

    fun provideContext(): Context

    fun inject(application: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(applicationContext: Context): Builder

        fun build(): AppComponent
    }
}
