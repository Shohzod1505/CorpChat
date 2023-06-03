package ru.itis.kpfu.corpchat.presentation.screen.auth.user;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthUserSignUpBinding
import javax.inject.Inject

class AuthUserSignUpFragment : DaggerFragment(R.layout.fragment_auth_user_sign_up) {
    private var binding: FragmentAuthUserSignUpBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthUserSignUpViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthUserSignUpBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
