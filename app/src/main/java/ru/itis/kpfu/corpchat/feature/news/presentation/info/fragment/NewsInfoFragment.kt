package ru.itis.kpfu.corpchat.feature.news.presentation.info.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentNewsInfoBinding
import ru.itis.kpfu.corpchat.feature.news.presentation.info.viewmodel.NewsInfoViewModel
import javax.inject.Inject

class NewsInfoFragment : DaggerFragment(R.layout.fragment_news_info) {
    private val binding by viewBinding(FragmentNewsInfoBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: NewsInfoViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()

        with(binding) {

            val newsId = arguments?.getString("newsId")
            viewModel.shareNews(newsId)

        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            arrayNews.observe(viewLifecycleOwner) {
                show(it[0], it[1], it[2])
            }
        }
    }

    private fun show(
        title: String,
        text: String,
        image: String,
    ) {
        with(binding) {
            tvTitle.text = title
            tvText.text = text
            Glide.with(this@NewsInfoFragment)
                .load(image)
                .centerCrop()
                .transform(CircleCrop())
                .into(ivNews)
        }
    }

}
