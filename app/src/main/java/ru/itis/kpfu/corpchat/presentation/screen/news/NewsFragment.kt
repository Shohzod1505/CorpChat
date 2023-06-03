package ru.itis.kpfu.corpchat.presentation.screen.news;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.kpfu.corpchat.databinding.FragmentNewsFeedBinding

class NewsFragment : Fragment() {
    private var binding: FragmentNewsFeedBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsFeedBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
