package ru.itis.kpfu.corpchat.presentation.screen.auth.company.logo;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthCompanySignUpLogoBinding
import javax.inject.Inject

class AuthCompanySignUpLogoFragment : DaggerFragment(R.layout.fragment_auth_company_sign_up_logo) {
    private var binding: FragmentAuthCompanySignUpLogoBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthCompanySignUpLogoViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthCompanySignUpLogoBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
