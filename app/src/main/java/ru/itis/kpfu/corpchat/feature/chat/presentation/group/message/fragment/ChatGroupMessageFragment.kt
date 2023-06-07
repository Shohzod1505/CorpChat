package ru.itis.kpfu.corpchat.feature.chat.presentation.group.message.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatGroupMessageBinding
import ru.itis.kpfu.corpchat.feature.chat.presentation.group.message.viewmodel.ChatGroupMessageViewModel
import javax.inject.Inject

class ChatGroupMessageFragment : DaggerFragment(R.layout.fragment_chat_group_message) {
    private val binding by viewBinding(FragmentChatGroupMessageBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatGroupMessageViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

        }
    }

}
