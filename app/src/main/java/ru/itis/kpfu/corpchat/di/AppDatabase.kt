package ru.itis.kpfu.corpchat.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.itis.kpfu.corpchat.feature.news.data.News
import ru.itis.kpfu.corpchat.feature.news.data.NewsDao

@Database(entities = [News::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getNewsDao(): NewsDao

    companion object {
        private const val DATABASE_NAME = "corpchat.db"
        private var db_instance: AppDatabase? = null

        fun getAppDatabaseInstance(context: Context): AppDatabase {

            if (db_instance == null) {
                db_instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return db_instance as AppDatabase
        }
    }

}
