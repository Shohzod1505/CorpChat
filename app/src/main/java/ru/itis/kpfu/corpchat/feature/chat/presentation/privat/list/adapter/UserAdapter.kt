package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.kpfu.corpchat.feature.auth.domain.UsersInfo

class UserAdapter(
    private val itemBinding: Boolean,
    private val glide: RequestManager,
    private val action: (UsersInfo) -> Unit,
) : ListAdapter<UsersInfo, RecyclerView.ViewHolder>(TodoListDiff) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder = if(itemBinding){
            LinearUserHolder.create(parent, glide, action)
        }
        else {
            GridUserHolder.create(parent, glide, action)
        }


    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when (holder) {
            is LinearUserHolder -> {
                holder.onBind(getItem(position))
            }
            is GridUserHolder -> {
                holder.onBind(getItem(position))
            }
        }

    }

}
