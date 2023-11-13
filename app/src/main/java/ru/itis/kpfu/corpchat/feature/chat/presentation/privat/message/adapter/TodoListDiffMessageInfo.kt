package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.itis.kpfu.corpchat.feature.chat.domain.MessageInfo

object TodoListDiffMessageInfo : DiffUtil.ItemCallback<MessageInfo>(){
    override fun areItemsTheSame(
        oldItem: MessageInfo,
        newItem: MessageInfo
    ): Boolean = oldItem.messageId == newItem.messageId

    override fun areContentsTheSame(
        oldItem: MessageInfo,
        newItem: MessageInfo
    ): Boolean = oldItem == newItem
}
