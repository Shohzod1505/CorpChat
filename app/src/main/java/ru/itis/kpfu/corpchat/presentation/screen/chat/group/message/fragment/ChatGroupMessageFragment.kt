package ru.itis.kpfu.corpchat.presentation.screen.chat.group.message.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatGroupMessageBinding
import ru.itis.kpfu.corpchat.presentation.screen.chat.group.message.viewmodel.ChatGroupMessageViewModel
import javax.inject.Inject

class ChatGroupMessageFragment : DaggerFragment(R.layout.fragment_chat_group_message) {
    private var binding: FragmentChatGroupMessageBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatGroupMessageViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatGroupMessageBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
