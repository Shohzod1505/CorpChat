package ru.itis.kpfu.corpchat.feature.news.presentation.feed.fragment

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
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentNewsFeedBinding
import ru.itis.kpfu.corpchat.feature.news.domain.NewsInfo
import ru.itis.kpfu.corpchat.feature.news.presentation.feed.adapter.LinearSpaceItemDecorator
import ru.itis.kpfu.corpchat.feature.news.presentation.feed.adapter.NewsAdapter
import ru.itis.kpfu.corpchat.feature.news.presentation.feed.viewmodel.NewsFeedViewModel
import ru.itis.kpfu.corpchat.utils.SharedPreferences.APP_PREFERENCES
import ru.itis.kpfu.corpchat.utils.SharedPreferences.ITEM_BINDING
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_COMPANY_ID
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_EMAIL
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_USER_ID
import ru.itis.kpfu.corpchat.utils.show
import ru.itis.kpfu.homework.adapter.GridSpaceItemDecorator
import javax.inject.Inject

class NewsFeedFragment : DaggerFragment(R.layout.fragment_news_feed) {
    private val binding by viewBinding(FragmentNewsFeedBinding::bind)
    private var preferences: SharedPreferences? = null
    private var listAdapter: NewsAdapter? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: NewsFeedViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        observeViewModel()
        val bindingFlag = preferences?.getBoolean(ITEM_BINDING, true)

        show(R.id.bnv_menu)
        show(R.id.toolbar)

        with(binding) {

            val bundle = Bundle()
            listAdapter = NewsAdapter(itemBinding = bindingFlag!!,
                glide = Glide.with(this@NewsFeedFragment),
                action = {
                    bundle.putString("newsId", it.id)
             findNavController().navigate(R.id.action_newsFeedFragment_to_newsInfoFragment, bundle)
            })

            rvNews.adapter = listAdapter

            if (bindingFlag == true) {
                rvNews.layoutManager = LinearLayoutManager(requireContext())
                rvNews.addItemDecoration(LinearSpaceItemDecorator(requireContext(),16f))
            }
            else {
                rvNews.layoutManager = GridLayoutManager(requireContext(), 2)
                rvNews.addItemDecoration(GridSpaceItemDecorator(requireContext(), 16f))
            }

            val companyId = preferences?.getString(PREF_COMPANY_ID, null)
            val userId = preferences?.getString(PREF_USER_ID, null)
            val email = preferences?.getString(PREF_EMAIL, null)

            fbAddNews.setOnClickListener {
                findNavController().navigate(R.id.action_newsFeedFragment_to_newsEditFragment)
            }

            if (email != null) {
//                viewModel.findId(email)
            }
            viewModel.getList()

        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            url.observe(viewLifecycleOwner) {
                show(it)
            }
            list.observe(viewLifecycleOwner) {
                setList(it)
            }
        }
    }

    private fun setList(
        list: ArrayList<NewsInfo>
    ) {
        listAdapter?.submitList(list)
    }

    private fun show(url: String) {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .transform(CircleCrop())
            .into(binding.ivPhoto)
    }

}
