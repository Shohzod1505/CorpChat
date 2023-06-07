package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatPrivateListBinding
import ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.viewmodel.ChatPrivateListViewModel
import javax.inject.Inject

class ChatPrivateListFragment : DaggerFragment(R.layout.fragment_chat_private_list) {
    private val binding by viewBinding(FragmentChatPrivateListBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatPrivateListViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

        }
    }

}
