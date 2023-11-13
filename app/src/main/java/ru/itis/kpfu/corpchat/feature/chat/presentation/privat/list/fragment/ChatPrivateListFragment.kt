package ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentChatPrivateListBinding
import ru.itis.kpfu.corpchat.feature.auth.domain.UsersInfo
import ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.adapter.UserAdapter
import ru.itis.kpfu.corpchat.feature.chat.presentation.privat.list.viewmodel.ChatPrivateListViewModel
import ru.itis.kpfu.corpchat.feature.news.presentation.feed.adapter.LinearSpaceItemDecorator
import ru.itis.kpfu.corpchat.utils.SharedPreferences.APP_PREFERENCES
import ru.itis.kpfu.corpchat.utils.SharedPreferences.ITEM_BINDING
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_EMAIL
import ru.itis.kpfu.homework.adapter.GridSpaceItemDecorator
import javax.inject.Inject

class ChatPrivateListFragment : DaggerFragment(R.layout.fragment_chat_private_list) {
    private val binding by viewBinding(FragmentChatPrivateListBinding::bind)
    private var preferences: SharedPreferences? = null
    private var listAdapter: UserAdapter? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ChatPrivateListViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        observeViewModel()
        val bindingFlag = preferences?.getBoolean(ITEM_BINDING, true)

        with(binding) {

            val bundle = Bundle()
            listAdapter = UserAdapter(itemBinding = bindingFlag!!,
                glide = Glide.with(this@ChatPrivateListFragment),
                action = {
                    bundle.putString("userId", it.email)
                    findNavController().navigate(R.id.action_chatPrivateListFragment_to_chatPrivateMessageFragment, bundle)
                })

            rvUser.adapter = listAdapter

            if (bindingFlag == true) {
                rvUser.layoutManager = LinearLayoutManager(requireContext())
                rvUser.addItemDecoration(LinearSpaceItemDecorator(requireContext(),16f))
            }
            else {
                rvUser.layoutManager = GridLayoutManager(requireContext(), 2)
                rvUser.addItemDecoration(GridSpaceItemDecorator(requireContext(), 16f))
            }
            val currentUser = preferences?.getString(PREF_EMAIL, null).toString()
            viewModel.getList(currentUser)

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
        list: ArrayList<UsersInfo>
    ) {
        listAdapter?.submitList(list)
    }

}
