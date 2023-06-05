package ru.itis.kpfu.corpchat.feature.chat.presentation.group.list.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatGroupListBinding
import ru.itis.kpfu.corpchat.feature.chat.presentation.group.list.viewmodel.ChatGroupListViewModel
import javax.inject.Inject

class ChatGroupListFragment : DaggerFragment(R.layout.fragment_chat_group_list) {
    private var binding: FragmentChatGroupListBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatGroupListViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatGroupListBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
