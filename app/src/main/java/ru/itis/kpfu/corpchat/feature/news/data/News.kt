package ru.itis.kpfu.corpchat.feature.news.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class News(
    @PrimaryKey val id: String,
    val title: String?,
    val text: String?,
    val image: String?,
    val author: String?,
    val date: Long?,
)
