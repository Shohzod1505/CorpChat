package ru.itis.kpfu.corpchat.presentation.screen.auth.company.name;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthCompanySignUpNameBinding
import javax.inject.Inject

class AuthCompanySignUpNameFragment : DaggerFragment(R.layout.fragment_auth_company_sign_up_name) {
    private var binding: FragmentAuthCompanySignUpNameBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthCompanySignUpNameViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthCompanySignUpNameBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
