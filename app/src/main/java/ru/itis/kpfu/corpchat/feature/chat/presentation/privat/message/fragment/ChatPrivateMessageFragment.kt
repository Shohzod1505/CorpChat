package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.message.fragment;

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatPrivateMessageBinding
import ru.itis.kpfu.corpchat.feature.chat.domain.MessageInfo
import ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.adapter.MessageAdapter
import ru.itis.kpfu.corpchat.feature.chat.presentation.privat.message.viewmodel.ChatPrivateMessageViewModel
import ru.itis.kpfu.corpchat.utils.SharedPreferences.APP_PREFERENCES
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_EMAIL
import ru.itis.kpfu.corpchat.utils.getTextAsString
import javax.inject.Inject

class ChatPrivateMessageFragment : DaggerFragment(R.layout.fragment_chat_private_message) {
    private val binding by viewBinding(FragmentChatPrivateMessageBinding::bind)
    private var preferences: SharedPreferences? = null
    private var listAdapter: MessageAdapter? = null
    private val auth: FirebaseAuth? = null
    private val firebaseDatabase: FirebaseDatabase? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatPrivateMessageViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        var bindingFlag = true
        observeViewModel()

        with(binding) {

            btSend.setOnClickListener {
                val senderId = preferences?.getString(PREF_EMAIL, null).toString()
                val receiveId = arguments?.getString("userId").toString()
                val message = etMessage.getTextAsString()
                bindingFlag = viewModel.chooseSide(senderId)
                viewModel.sendMessage(senderId, receiveId, message)
                viewModel.getList(senderId, receiveId)
            }

            val bundle = Bundle()
            listAdapter = MessageAdapter(itemBinding = bindingFlag,
                glide = Glide.with(this@ChatPrivateMessageFragment),
                action = {
                    bundle.putString("userId", it.message)
                    findNavController().navigate(R.id.action_chatPrivateListFragment_to_chatPrivateMessageFragment, bundle)
                })

            rvNews.adapter = listAdapter
            rvNews.layoutManager = LinearLayoutManager(requireContext())

        }

    }

    private fun observeViewModel() {
        with(viewModel) {
            list.observe(viewLifecycleOwner) {
                setList(it)
            }
        }
    }

    private fun setList(
        list: ArrayList<MessageInfo>
    ) {
        listAdapter?.submitList(list)
    }

}
