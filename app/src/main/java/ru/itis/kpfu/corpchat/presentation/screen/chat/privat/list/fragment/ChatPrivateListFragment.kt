package ru.itis.kpfu.corpchat.presentation.screen.chat.privat.list.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatPrivateListBinding
import ru.itis.kpfu.corpchat.presentation.screen.chat.privat.list.viewmodel.ChatPrivateListViewModel
import javax.inject.Inject

class ChatPrivateListFragment : DaggerFragment(R.layout.fragment_chat_private_list) {
    private var binding: FragmentChatPrivateListBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatPrivateListViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatPrivateListBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
