package ru.itis.kpfu.corpchat.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.itis.kpfu.corpchat.utils.ResourceProvider
import ru.itis.kpfu.corpchat.utils.ResourceProviderImpl

@Module
class AppModule {

//    @Singleton
//    @Provides
//    fun getRoomDbInstance(
//        context: Context
//    ): AppDatabase {
//        return AppDatabase.getAppDatabaseInstance(context)
//    }
//
//    @Singleton
//    @Provides
//    fun getWeatherDao(appDatabase: AppDatabase): WeatherDao {
//        return appDatabase.getWeatherDao()
//    }

    @Provides
    fun provideResourceProvider(
        context: Context
    ): ResourceProvider = ResourceProviderImpl(context)

}
