package ru.itis.kpfu.corpchat.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.itis.kpfu.corpchat.feature.news.data.NewsDao
import ru.itis.kpfu.corpchat.utils.ResourceProvider
import ru.itis.kpfu.corpchat.utils.ResourceProviderImpl
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun getRoomDbInstance(
        context: Context
    ): AppDatabase {
        return AppDatabase.getAppDatabaseInstance(context)
    }

    @Singleton
    @Provides
    fun getNewsDao(appDatabase: AppDatabase): NewsDao {
        return appDatabase.getNewsDao()
    }

    @Provides
    fun provideResourceProvider(
        context: Context
    ): ResourceProvider = ResourceProviderImpl(context)

}
