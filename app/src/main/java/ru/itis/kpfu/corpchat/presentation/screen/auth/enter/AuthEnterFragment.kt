package ru.itis.kpfu.corpchat.presentation.screen.auth.enter;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthEnterBinding
import javax.inject.Inject

class AuthEnterFragment : DaggerFragment(R.layout.fragment_auth_enter) {
    private var binding: FragmentAuthEnterBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthEnterViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthEnterBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
