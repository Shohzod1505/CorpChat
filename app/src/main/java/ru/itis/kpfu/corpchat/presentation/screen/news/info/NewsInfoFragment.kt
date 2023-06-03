package ru.itis.kpfu.corpchat.presentation.screen.news.info;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentNewsInfoBinding
import javax.inject.Inject

class NewsInfoFragment : DaggerFragment(R.layout.fragment_news_info) {
    private var binding: FragmentNewsInfoBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: NewsInfoViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsInfoBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
