package ru.itis.kpfu.corpchat.feature.work.presentation;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentWorkBinding

class WorkFragment : Fragment(R.layout.fragment_work) {
    private var binding: FragmentWorkBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWorkBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
