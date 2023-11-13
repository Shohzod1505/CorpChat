package ru.itis.kpfu.corpchat.feature.chat.presentation.channel.list.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatChannelListBinding
import ru.itis.kpfu.corpchat.feature.chat.presentation.channel.list.viewmodel.ChatChannelListViewModel
import javax.inject.Inject

class ChatChannelListFragment : DaggerFragment(R.layout.fragment_chat_channel_list) {
    private val binding by viewBinding(FragmentChatChannelListBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatChannelListViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

        }
    }

}
