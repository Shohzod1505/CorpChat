package ru.itis.kpfu.corpchat.feature.auth.presentation.user.fragment

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
import ru.itis.kpfu.corpchat.databinding.FragmentAuthUserSignUpNameBinding
import ru.itis.kpfu.corpchat.feature.auth.presentation.user.viewmodel.AuthUserSignUpNameViewModel
import ru.itis.kpfu.corpchat.utils.SharedPreferences.APP_PREFERENCES
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_EMAIL
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_USER_ID
import ru.itis.kpfu.corpchat.utils.checkField
import ru.itis.kpfu.corpchat.utils.getTextAsString
import javax.inject.Inject

class AuthUserSignUpNameFragment : DaggerFragment(R.layout.fragment_auth_user_sign_up_name) {
    private val binding by viewBinding(FragmentAuthUserSignUpNameBinding::bind)
    private var preferences: SharedPreferences? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthUserSignUpNameViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

        with(binding) {

            val userId = preferences?.getString(PREF_USER_ID, "error")
            val email = preferences?.getString(PREF_EMAIL, "error")

            btNext.setOnClickListener {
                val name = etName.getTextAsString()
                val lastName = etLastName.getTextAsString()
                val phone = etPhone.getTextAsString()
                val company = etCompany.getTextAsString()
                val code = etCompanyCode.getTextAsString()

                val error = context?.getString(R.string.error_signUp).toString()
                val nameIsEmpty = etName.checkField(error)
                val lastNameIsEmpty = etLastName.checkField(error)
                val phoneIsEmpty = etPhone.checkField(error)
                val companyIsEmpty = etCompany.checkField(error)
                val companyCodeIsEmpty = etCompanyCode.checkField(error)

                if (nameIsEmpty && lastNameIsEmpty && phoneIsEmpty &&
                        companyIsEmpty && companyCodeIsEmpty) {
                    viewModel.updateUser(userId, name, lastName, phone, company, code,
                        onSuccess = {
                            findNavController().navigate(R.id.action_authUserSignUpNameFragment_to_authSignUpPhotoFragment)
                        },
                        onFailure = {})
                }
           }

        }
    }

}
