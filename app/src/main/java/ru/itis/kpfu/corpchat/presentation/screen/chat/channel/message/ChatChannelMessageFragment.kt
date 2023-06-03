package ru.itis.kpfu.corpchat.presentation.screen.chat.channel.message;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatChannelMessageBinding
import javax.inject.Inject

class ChatChannelMessageFragment : DaggerFragment(R.layout.fragment_chat_channel_message) {
    private var binding: FragmentChatChannelMessageBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatChannelMessageViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatChannelMessageBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
