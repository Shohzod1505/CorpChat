package ru.itis.kpfu.corpchat.feature.news.presentation.edit.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentNewsEditBinding
import ru.itis.kpfu.corpchat.feature.news.presentation.edit.viewmodel.NewsEditViewModel
import javax.inject.Inject

class NewsEditFragment : DaggerFragment(R.layout.fragment_news_edit) {
    private var binding: FragmentNewsEditBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: NewsEditViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsEditBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
