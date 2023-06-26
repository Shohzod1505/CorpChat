package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.message.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatPrivateMessageBinding
import ru.itis.kpfu.corpchat.feature.chat.presentation.privat.message.viewmodel.ChatPrivateMessageViewModel
import javax.inject.Inject

class ChatPrivateMessageFragment : DaggerFragment(R.layout.fragment_chat_private_message) {
    private var binding: FragmentChatPrivateMessageBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatPrivateMessageViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatPrivateMessageBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
