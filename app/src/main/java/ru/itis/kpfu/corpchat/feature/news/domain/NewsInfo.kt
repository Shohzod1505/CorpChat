package ru.itis.kpfu.corpchat.feature.news.domain

data class NewsInfo(
    val id: String,
    val title: String?,
    val text: String?,
    val image: String?,
    val author: String?,
    val date: Long?,
) {
    constructor() : this(
        id = "",
        title = "",
        text = "",
        image = "",
        author = "",
        date = 0
    )
}

