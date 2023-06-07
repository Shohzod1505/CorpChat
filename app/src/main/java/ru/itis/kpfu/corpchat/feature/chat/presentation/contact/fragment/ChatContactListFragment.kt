package ru.itis.kpfu.corpchat.feature.chat.presentation.contact.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatContactListBinding
import ru.itis.kpfu.corpchat.feature.chat.presentation.contact.viewmodel.ChatContactListViewModel
import javax.inject.Inject

class ChatContactListFragment : DaggerFragment(R.layout.fragment_chat_contact_list) {
    private val binding by viewBinding(FragmentChatContactListBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatContactListViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            findNavController().navigate(R.id.action_chatContactListFragment_to_chatPrivateListFragment)
        }
    }

}
