package ru.itis.kpfu.corpchat.presentation.screen.chat.channel.list;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatChannelListBinding
import javax.inject.Inject

class ChatChannelListFragment : DaggerFragment(R.layout.fragment_chat_channel_list) {
    private var binding: FragmentChatChannelListBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatChannelListViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatChannelListBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
