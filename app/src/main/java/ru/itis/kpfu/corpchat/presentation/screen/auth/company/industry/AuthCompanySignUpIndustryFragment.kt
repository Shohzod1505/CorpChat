package ru.itis.kpfu.corpchat.presentation.screen.auth.company.industry;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthCompanySignUpIndustryBinding
import javax.inject.Inject

class AuthCompanySignUpIndustryFragment : DaggerFragment(R.layout.fragment_auth_company_sign_up_industry) {
    private var binding: FragmentAuthCompanySignUpIndustryBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthCompanySignUpIndustryViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthCompanySignUpIndustryBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
