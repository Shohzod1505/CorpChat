package ru.itis.kpfu.corpchat.feature.news.presentation.feed.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentNewsFeedBinding
import ru.itis.kpfu.corpchat.feature.news.presentation.feed.viewmodel.NewsFeedViewModel
import ru.itis.kpfu.corpchat.utils.SharedPreferences.APP_PREFERENCES
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_COMPANY_ID
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_EMAIL
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_USER_ID
import ru.itis.kpfu.corpchat.utils.show
import javax.inject.Inject

class NewsFeedFragment : DaggerFragment(R.layout.fragment_news_feed) {
    private val binding by viewBinding(FragmentNewsFeedBinding::bind)
    private var preferences: SharedPreferences? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: NewsFeedViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        observeViewModel()

        show(R.id.bnv_menu)

        with(binding) {
            val companyId = preferences?.getString(PREF_COMPANY_ID, null)
            val userId = preferences?.getString(PREF_USER_ID, null)
            val email = preferences?.getString(PREF_EMAIL, null)

            if (email != null) {
                viewModel.findId(email)
            }

        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            url.observe(viewLifecycleOwner) {
                show(it)
            }
        }
    }

    private fun show(url: String) {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .transform(CircleCrop())
            .into(binding.ivPhoto)
    }

}
