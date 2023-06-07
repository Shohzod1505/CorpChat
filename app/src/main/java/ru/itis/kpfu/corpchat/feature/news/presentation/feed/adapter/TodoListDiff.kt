package ru.itis.kpfu.corpchat.feature.news.presentation.feed.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.itis.kpfu.corpchat.feature.news.domain.NewsInfo

object TodoListDiff : DiffUtil.ItemCallback<NewsInfo>(){
    override fun areItemsTheSame(
        oldItem: NewsInfo,
        newItem: NewsInfo
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: NewsInfo,
        newItem: NewsInfo
    ): Boolean = oldItem == newItem
}
