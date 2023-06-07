package ru.itis.kpfu.corpchat.feature.work.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentWorkBinding

class WorkFragment : Fragment(R.layout.fragment_work) {
    private val binding by viewBinding(FragmentWorkBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

        }

    }

}
