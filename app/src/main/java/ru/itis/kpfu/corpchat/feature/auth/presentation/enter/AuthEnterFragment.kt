package ru.itis.kpfu.corpchat.feature.auth.presentation.enter;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthEnterBinding
import ru.itis.kpfu.corpchat.utils.hide
import ru.itis.kpfu.corpchat.utils.show

class AuthEnterFragment : Fragment(R.layout.fragment_auth_enter) {
    private var binding: FragmentAuthEnterBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthEnterBinding.bind(view)

        hide(R.id.bnv_menu)

        binding?.run {

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

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
