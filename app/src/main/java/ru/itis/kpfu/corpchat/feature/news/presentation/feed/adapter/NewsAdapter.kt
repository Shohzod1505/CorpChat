package ru.itis.kpfu.corpchat.feature.news.presentation.feed.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.kpfu.corpchat.feature.news.domain.NewsInfo

class NewsAdapter(
    private val itemBinding: Boolean,
    private val glide: RequestManager,
    private val action: (NewsInfo) -> Unit,
) : ListAdapter<NewsInfo, RecyclerView.ViewHolder>(TodoListDiff) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder = if(itemBinding){
            LinearNewsHolder.create(parent, glide, action)
        }
        else {
            GridNewsHolder.create(parent, glide, action)
        }


    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when (holder) {
            is LinearNewsHolder -> {
                holder.onBind(getItem(position))
            }
            is GridNewsHolder -> {
                holder.onBind(getItem(position))
            }
        }

    }

}
