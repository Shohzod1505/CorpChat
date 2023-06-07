package ru.itis.kpfu.corpchat.feature.news.presentation.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.kpfu.corpchat.databinding.ItemNewsLinearBinding
import ru.itis.kpfu.corpchat.feature.news.domain.NewsInfo

class GridNewsHolder(
    private val binding: ItemNewsLinearBinding,
    private val glide: RequestManager,
    private val action: (NewsInfo) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private var newsInfo: NewsInfo? = null

    init {
        binding.root.setOnClickListener {
            newsInfo?.also(action)
        }
    }

    fun onBind(newsInfo: NewsInfo) {
        this.newsInfo = newsInfo
        with(binding) {
            tvTitle.text = newsInfo.title
            tvText.text = newsInfo.text
            glide
                .load(newsInfo.image)
                .centerCrop()
                .into(ivNews)
//            ivDelete.setImageResource(R.drawable.ic_baseline_delete_24)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            glide: RequestManager,
            action: (NewsInfo) -> Unit,
        ): GridNewsHolder = GridNewsHolder(
            binding = ItemNewsLinearBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            action = action,
        )
    }

}
