package ru.itis.kpfu.corpchat.feature.auth.presentation.enter.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthEnterBinding
import ru.itis.kpfu.corpchat.feature.auth.presentation.enter.viewmodel.AuthEnterViewModel
import ru.itis.kpfu.corpchat.utils.hide
import javax.inject.Inject

class AuthEnterFragment : DaggerFragment(R.layout.fragment_auth_enter) {

    private val binding by viewBinding(FragmentAuthEnterBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthEnterViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (viewModel.checkUserSignIn()) {
            findNavController().navigate(R.id.action_authEnterFragment_to_newsFeedFragment)
        }

        hide(R.id.bnv_menu)
        hide(R.id.toolbar)

        with(binding) {

            btUser.setOnClickListener {
                navigate(R.string.auth_title_user_sign_in, "User")
            }
            btCompany.setOnClickListener {
                navigate(R.string.auth_title_company_sign_in, "Company")
            }
            btEnter.setOnClickListener {
                navigate(R.string.auth_title_exist_sign_in, "Exist")
            }
        }
    }

    private fun navigate(title: Int, type: String) {
        val bundle = Bundle()
        val text = context?.getString(title)
        bundle.putString("Title", text)
        bundle.putString("Type", type)
        findNavController().navigate(
            R.id.action_authEnterFragment_to_authSignInFragment,
            bundle
        )
    }

}
