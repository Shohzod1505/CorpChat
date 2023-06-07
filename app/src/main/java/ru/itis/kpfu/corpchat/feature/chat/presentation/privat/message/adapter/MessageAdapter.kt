package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.kpfu.corpchat.feature.chat.domain.MessageInfo

class MessageAdapter(
    private val itemBinding: Boolean,
    private val glide: RequestManager,
    private val action: (MessageInfo) -> Unit,
) : ListAdapter<MessageInfo, RecyclerView.ViewHolder>(TodoListDiffMessageInfo) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder = if(itemBinding){
            LinearMessageHolder.create(parent, glide, action)
        }
        else {
            GridMessageHolder.create(parent, glide, action)
        }


    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when (holder) {
            is LinearMessageHolder -> {
                holder.onBind(getItem(position))
            }
            is GridMessageHolder -> {
                holder.onBind(getItem(position))
            }
        }

    }

}
