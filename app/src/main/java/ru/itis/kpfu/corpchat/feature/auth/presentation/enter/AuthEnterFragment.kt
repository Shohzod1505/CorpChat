package ru.itis.kpfu.corpchat.feature.auth.presentation.enter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthEnterBinding
import ru.itis.kpfu.corpchat.utils.hide

class AuthEnterFragment : Fragment(R.layout.fragment_auth_enter) {

    private val binding by viewBinding(FragmentAuthEnterBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hide(R.id.bnv_menu)

        with(binding) {

            btUser.setOnClickListener {
                navigate(R.string.auth_title_user_sign_in, 0)
            }
            btCompany.setOnClickListener {
                navigate(R.string.auth_title_company_sign_in, 1)
            }
            btEnter.setOnClickListener {
                navigate(R.string.auth_title_exist_sign_in, 2)
            }
        }
    }

    private fun navigate(title: Int, type: Int) {
        val bundle = Bundle()
        val text = context?.getString(title)
        bundle.putString("Title", text)
        bundle.putInt("Type", type)
        findNavController().navigate(
            R.id.action_authEnterFragment_to_authSignInFragment,
            bundle
        )
    }

}
