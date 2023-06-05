package ru.itis.kpfu.corpchat.presentation.screen.auth.company.name.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthCompanySignUpNameBinding
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.name.viewmodel.AuthCompanySignUpNameViewModel
import ru.itis.kpfu.corpchat.utils.convert
import java.util.HashMap
import javax.inject.Inject

class AuthCompanySignUpNameFragment : DaggerFragment(R.layout.fragment_auth_company_sign_up_name) {
    private var binding: FragmentAuthCompanySignUpNameBinding? = null
    private var dbReference: DatabaseReference? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthCompanySignUpNameViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthCompanySignUpNameBinding.bind(view)

        binding?.run {

            val bundle = Bundle()
            val userId = arguments?.getString("companyId")
            bundle.putString("companyId", userId)
            if (userId != null) {
                dbReference = FirebaseDatabase.getInstance().getReference("Company").child(userId)
            }
            val hashMap: HashMap<String, Any> = HashMap()

            btNext.setOnClickListener {
                hashMap["name"] = etName.convert()
                hashMap["address"] = etAddress.convert()
                hashMap["phone"] = etPhone.convert()
                dbReference?.updateChildren(hashMap)
                findNavController().navigate(
                    R.id.action_authCompanySignUpNameFragment_to_authCompanySignUpIndustryFragment,
                    bundle
                )
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
