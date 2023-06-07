package ru.itis.kpfu.corpchat.feature.auth.presentation.signin.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthSignInBinding
import ru.itis.kpfu.corpchat.feature.auth.presentation.signin.viewmodel.AuthSignInViewModel
import ru.itis.kpfu.corpchat.utils.SharedPreferences.APP_PREFERENCES
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_COMPANY_ID
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_EMAIL
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_USER_ID
import ru.itis.kpfu.corpchat.utils.checkField
import ru.itis.kpfu.corpchat.utils.getTextAsString
import javax.inject.Inject

class AuthSignInFragment : DaggerFragment(R.layout.fragment_auth_sign_in) {
    private val binding by viewBinding(FragmentAuthSignInBinding::bind)
    private var preferences: SharedPreferences? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthSignInViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        observeViewModel()

        with(binding) {
            val title = arguments?.getString("Title")
            val type = arguments?.getString("Type").toString()
            tvSignIn.text = title

            btSignIn.setOnClickListener {
                val email = etEmail.getTextAsString()
                val password = etPassword.getTextAsString()

                val emailIsEmpty = etEmail.checkField("Enter email")
                val passwordIsEmpty = etPassword.checkField("Enter password")
                if (emailIsEmpty && passwordIsEmpty) {
                    when(type) {
                        "User" -> {
                            viewModel.signIn(email, password, type)
                        }
                        "Company" -> {
                            viewModel.signIn(email, password, type)
                        }
                        "Exist" -> {
                            viewModel.signInExistAccount(email, password)
                        }
                    }
                    preferences?.edit {
                        putString(PREF_EMAIL, email)
                        commit()
                    }
                }
            }

        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            arraySignIn.observe(viewLifecycleOwner) {
                navigate(it[0], it[1], it[2])
            }
            companyId.observe(viewLifecycleOwner) {
                navigateCompany(it)
            }
            userId.observe(viewLifecycleOwner) {
                navigateUser(it)
            }
        }
    }

    private fun navigateCompany(
        id: String,
    ) {
        preferences?.edit {
            putString(PREF_COMPANY_ID, id)
            commit()
        }
        findNavController().navigate(R.id.action_authSignInFragment_to_newsFeedFragment)
    }

    private fun navigateUser(
        id: String,
    ) {
        preferences?.edit {
            putString(PREF_USER_ID, id)
            commit()
        }
        findNavController().navigate(R.id.action_authSignInFragment_to_newsFeedFragment)
    }

    private fun navigate(
        type: String,
        id: String,
        email: String,
    ) {
        when (type) {
            "User" -> {
                preferences?.edit {
                    putString(PREF_USER_ID, id)
                    commit()
                }
                findNavController().navigate(R.id.action_authSignInFragment_to_authUserSignUpNameFragment)
            }
            "Company" -> {
                preferences?.edit {
                    putString(PREF_COMPANY_ID, id)
                    commit()
                }
                findNavController().navigate(R.id.action_authSignInFragment_to_authCompanySignUpNameFragment)
            }
        }
    }

}
