package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.kpfu.corpchat.databinding.ItemMessageLeftBinding
import ru.itis.kpfu.corpchat.feature.chat.domain.MessageInfo

class LinearMessageHolder(
    private val binding: ItemMessageLeftBinding,
    private val glide: RequestManager,
    private val action: (MessageInfo) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private var messageInfo: MessageInfo? = null

    init {
        binding.root.setOnClickListener {
            messageInfo?.also(action)
        }
    }

    fun onBind(messageInfo: MessageInfo) {
        this.messageInfo = messageInfo
        with(binding) {
            tvName.text = messageInfo.message
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            glide: RequestManager,
            action: (MessageInfo) -> Unit,
        ): LinearMessageHolder = LinearMessageHolder(
            binding = ItemMessageLeftBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            action = action,
        )
    }

}
