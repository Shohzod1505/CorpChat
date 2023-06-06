package ru.itis.kpfu.corpchat.feature.auth.presentation.user.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthUserSignUpNameBinding
import ru.itis.kpfu.corpchat.feature.auth.presentation.user.viewmodel.AuthUserSignUpNameViewModel
import ru.itis.kpfu.corpchat.utils.getTextAsString
import javax.inject.Inject

class AuthUserSignUpNameFragment : DaggerFragment(R.layout.fragment_auth_user_sign_up_name) {
    private val binding by viewBinding(FragmentAuthUserSignUpNameBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthUserSignUpNameViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            val userId = arguments?.getString("userId")

            btNext.setOnClickListener {
                val name = etName.getTextAsString()
                val lastName = etLastName.getTextAsString()
                val phone = etPhone.getTextAsString()
                val company = etCompany.getTextAsString()
                val code = etCompanyCode.getTextAsString()
                viewModel.updateUser(userId, name, lastName, phone, company, code,
                    onSuccess = {
                        findNavController().navigate(R.id.action_authUserSignUpNameFragment_to_authSignUpPhotoFragment)
                    },
                    onFailure = {})
           }

        }
    }

}
