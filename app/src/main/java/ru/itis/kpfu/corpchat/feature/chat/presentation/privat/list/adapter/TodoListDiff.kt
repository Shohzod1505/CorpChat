package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.itis.kpfu.corpchat.feature.auth.domain.UsersInfo

object TodoListDiff : DiffUtil.ItemCallback<UsersInfo>(){
    override fun areItemsTheSame(
        oldItem: UsersInfo,
        newItem: UsersInfo
    ): Boolean = oldItem.userid == newItem.userid

    override fun areContentsTheSame(
        oldItem: UsersInfo,
        newItem: UsersInfo
    ): Boolean = oldItem == newItem
}
