package ru.itis.kpfu.corpchat.presentation.screen.chat.contact.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatContactListBinding
import ru.itis.kpfu.corpchat.presentation.screen.chat.contact.viewmodel.ChatContactListViewModel
import javax.inject.Inject

class ChatContactListFragment : DaggerFragment(R.layout.fragment_chat_contact_list) {
    private var binding: FragmentChatContactListBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatContactListViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatContactListBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
