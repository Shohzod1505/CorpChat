package ru.itis.kpfu.corpchat.feature.auth.presentation.company.industry.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthCompanySignUpIndustryBinding
import ru.itis.kpfu.corpchat.feature.auth.presentation.company.industry.viewmodel.AuthCompanySignUpIndustryViewModel
import ru.itis.kpfu.corpchat.utils.SharedPreferences.APP_PREFERENCES
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_COMPANY_ID
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_EMAIL
import javax.inject.Inject

class AuthCompanySignUpIndustryFragment : DaggerFragment(R.layout.fragment_auth_company_sign_up_industry) {
    private val binding by viewBinding(FragmentAuthCompanySignUpIndustryBinding::bind)
    private var preferences: SharedPreferences? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthCompanySignUpIndustryViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

        with(binding) {

            val industry = arrayListOf<String>()
            val checkBoxes = arrayOf(chB1, chB2, chB3, chB4, chB5, chB6, chB7, chB8, chB9, chB10)

            val companyId = preferences?.getString(PREF_COMPANY_ID, "error")
            val email = preferences?.getString(PREF_EMAIL, "error")

            btNext.setOnClickListener {
                for (checkBox in checkBoxes) {
                    if (checkBox.isChecked) {
                        industry.add(checkBox.text.toString())
                    }
                }
                viewModel.updateCompany(companyId, industry)
                findNavController().navigate(R.id.action_authCompanySignUpIndustryFragment_to_authSignUpPhotoFragment)
            }

        }

    }

}
