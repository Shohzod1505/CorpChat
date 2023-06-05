package ru.itis.kpfu.corpchat.feature.news.presentation.feed.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentNewsFeedBinding
import ru.itis.kpfu.corpchat.feature.news.presentation.feed.viewmodel.NewsFeedViewModel
import ru.itis.kpfu.corpchat.utils.show
import javax.inject.Inject

class NewsFeedFragment : DaggerFragment(R.layout.fragment_news_feed) {
    private var binding: FragmentNewsFeedBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: NewsFeedViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsFeedBinding.bind(view)
        show(R.id.bnv_menu)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
