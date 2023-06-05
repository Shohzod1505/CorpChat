package ru.itis.kpfu.corpchat.presentation.screen.auth.signin.fragment;

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthSignInBinding
import ru.itis.kpfu.corpchat.presentation.screen.auth.signin.viewmodel.AuthSignInViewModel
import ru.itis.kpfu.corpchat.utils.checkEmpty
import ru.itis.kpfu.corpchat.utils.convert
import javax.inject.Inject

class AuthSignInFragment : DaggerFragment(R.layout.fragment_auth_sign_in) {
    private var binding: FragmentAuthSignInBinding? = null
    private var auth: FirebaseAuth? = null
    private var dbReference: DatabaseReference? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthSignInViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthSignInBinding.bind(view)

        auth = Firebase.auth

        binding?.run {
            val title = arguments?.getString("Title")
            val type = arguments?.getInt("Type")
            tvSignIn.text = title
            btSignIn.setOnClickListener {
                val email = etEmail.convert()
                val password = etPassword.convert()

                when(type) {
                    0 -> {
                        signIn(email, password, "User")
                    }
                    1 -> {
                        signIn(email, password, "Company")
                    }
                    2 -> {
                        auth?.signInWithEmailAndPassword(email, password)
                        findNavController().navigate(R.id.action_authSignInFragment_to_newsFeedFragment)
                    }
                }
            }

        }
    }
    private fun signIn(
        email: String,
        password: String,
        type: String,
    ) {
        if (email.checkEmpty(requireContext(), "Email is required") &&
            password.checkEmpty(requireContext(), "Password is required")){
            viewModel.registerUser(
                email,
                password,
                type,
                onSuccess = { userId ->
                    val bundle = Bundle()
                    if (type == "User") {
                        bundle.putString("userId", userId)
                        findNavController().navigate(
                            R.id.action_authSignInFragment_to_authUserSignUpNameFragment,
                            bundle
                        )
                    } else {
                        bundle.putString("companyId", userId)
                        findNavController().navigate(
                            R.id.action_authSignInFragment_to_authCompanySignUpNameFragment,
                            bundle
                        )
                    }
                },
                onError = { errorMessage ->
                    Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                }
            )

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
