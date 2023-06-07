package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.kpfu.corpchat.databinding.ItemUserLinearBinding
import ru.itis.kpfu.corpchat.feature.auth.domain.UsersInfo

class LinearUserHolder(
    private val binding: ItemUserLinearBinding,
    private val glide: RequestManager,
    private val action: (UsersInfo) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private var usersInfo: UsersInfo? = null

    init {
        binding.root.setOnClickListener {
            usersInfo?.also(action)
        }
    }

    fun onBind(usersInfo: UsersInfo) {
        this.usersInfo = usersInfo
        with(binding) {
            tvName.text = "${usersInfo.name} ${usersInfo.lastname}"
            tvLastMessage.text = usersInfo.email
            glide
                .load(usersInfo.image)
                .centerCrop()
                .into(ivPhotoPerson)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            glide: RequestManager,
            action: (UsersInfo) -> Unit,
        ): LinearUserHolder = LinearUserHolder(
            binding = ItemUserLinearBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            action = action,
        )
    }

}
