package ru.itis.kpfu.corpchat.feature.auth.presentation.company.name.fragment

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
import ru.itis.kpfu.corpchat.databinding.FragmentAuthCompanySignUpNameBinding
import ru.itis.kpfu.corpchat.feature.auth.presentation.company.name.viewmodel.AuthCompanySignUpNameViewModel
import ru.itis.kpfu.corpchat.utils.SharedPreferences.APP_PREFERENCES
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_COMPANY_ID
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_EMAIL
import ru.itis.kpfu.corpchat.utils.checkField
import ru.itis.kpfu.corpchat.utils.getTextAsString
import javax.inject.Inject

class AuthCompanySignUpNameFragment : DaggerFragment(R.layout.fragment_auth_company_sign_up_name) {
    private val binding by viewBinding(FragmentAuthCompanySignUpNameBinding::bind)
    private var preferences: SharedPreferences? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthCompanySignUpNameViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

        with(binding) {

            val companyId = preferences?.getString(PREF_COMPANY_ID, "error")
            val email = preferences?.getString(PREF_EMAIL, "error")

            btNext.setOnClickListener {
                val name = etName.getTextAsString()
                val address = etAddress.getTextAsString()
                val phone = etPhone.getTextAsString()

                val error = context?.getString(R.string.error_signUp).toString()
                val nameIsEmpty = etName.checkField(error)
                val addressIsEmpty = etAddress.checkField(error)
                val phoneIsEmpty = etPhone.checkField(error)
                if (nameIsEmpty && addressIsEmpty && phoneIsEmpty) {
                    viewModel.updateCompany(companyId, name, address, phone)
                    findNavController().navigate(R.id.action_authCompanySignUpNameFragment_to_authCompanySignUpIndustryFragment,)
                }
            }
        }

    }

}
