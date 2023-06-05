package ru.itis.kpfu.corpchat.feature.news.presentation.feed.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentNewsFeedBinding
import ru.itis.kpfu.corpchat.feature.news.presentation.feed.viewmodel.NewsFeedViewModel
import ru.itis.kpfu.corpchat.utils.show
import javax.inject.Inject

class NewsFeedFragment : DaggerFragment(R.layout.fragment_news_feed) {
    private val binding by viewBinding(FragmentNewsFeedBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: NewsFeedViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        show(R.id.bnv_menu)

        with(binding) {

        }
    }

}
