package ru.itis.kpfu.corpchat.feature.chat.presentation.channel.message.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatChannelMessageBinding
import ru.itis.kpfu.corpchat.feature.chat.presentation.channel.message.viewmodel.ChatChannelMessageViewModel
import javax.inject.Inject

class ChatChannelMessageFragment : DaggerFragment(R.layout.fragment_chat_channel_message) {
    private val binding by viewBinding(FragmentChatChannelMessageBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatChannelMessageViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

        }
    }

}
