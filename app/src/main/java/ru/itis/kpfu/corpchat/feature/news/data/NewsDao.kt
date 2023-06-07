package ru.itis.kpfu.corpchat.feature.news.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(news: News)

    @Delete
    suspend fun delete(news: News)

//    @Query("SELECT * FROM news WHERE name = :name")
//    suspend fun findByName(name: String): News?

}
