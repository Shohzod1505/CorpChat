package ru.itis.kpfu.corpchat.feature.auth.presentation.signin.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthSignInBinding
import ru.itis.kpfu.corpchat.feature.auth.presentation.signin.viewmodel.AuthSignInViewModel
import ru.itis.kpfu.corpchat.utils.getTextAsString
import javax.inject.Inject

class AuthSignInFragment : DaggerFragment(R.layout.fragment_auth_sign_in) {
    private val binding by viewBinding(FragmentAuthSignInBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthSignInViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()

        with(binding) {
            val title = arguments?.getString("Title")
            val type = arguments?.getString("Type").toString()
            tvSignIn.text = title

            btSignIn.setOnClickListener {
                val email = etEmail.getTextAsString()
                val password = etPassword.getTextAsString()
                when(type) {
                    "User" -> {
                        viewModel.signIn(email, password, type)
                    }
                    "Company" -> {
                        viewModel.signIn(email, password, type)
                    }
                    "Exist" -> {
                        viewModel.signInExistAccount(email, password)
                        findNavController().navigate(R.id.action_authSignInFragment_to_newsFeedFragment)
                    }
                }
            }

        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            arraySignIn.observe(viewLifecycleOwner) {
                navigate(it[0], it[1])
            }
        }
    }

    private fun navigate(
        type: String,
        id: String,
    ) {
        val bundle = Bundle()
        when (type) {
            "User" -> {
                bundle.putString("userId", id)
                findNavController().navigate(
                    R.id.action_authSignInFragment_to_authUserSignUpNameFragment,
                    bundle
                )
            }
            "Company" -> {
                bundle.putString("companyId", id)
                findNavController().navigate(
                    R.id.action_authSignInFragment_to_authCompanySignUpNameFragment,
                    bundle
                )
            }
        }
    }

}
