package ru.itis.kpfu.corpchat.feature.auth.presentation.company.name.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthCompanySignUpNameBinding
import ru.itis.kpfu.corpchat.feature.auth.presentation.company.name.viewmodel.AuthCompanySignUpNameViewModel
import ru.itis.kpfu.corpchat.utils.getTextAsString
import java.util.HashMap
import javax.inject.Inject

class AuthCompanySignUpNameFragment : DaggerFragment(R.layout.fragment_auth_company_sign_up_name) {
    private val binding by viewBinding(FragmentAuthCompanySignUpNameBinding::bind)
    private var dbReference: DatabaseReference? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthCompanySignUpNameViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            val bundle = Bundle()
            val userId = arguments?.getString("companyId")
            bundle.putString("companyId", userId)
            if (userId != null) {
                dbReference = FirebaseDatabase.getInstance().getReference("Company").child(userId)
            }
            val hashMap: HashMap<String, Any> = HashMap()

            btNext.setOnClickListener {
                hashMap["name"] = etName.getTextAsString()
                hashMap["address"] = etAddress.getTextAsString()
                hashMap["phone"] = etPhone.getTextAsString()
                dbReference?.updateChildren(hashMap)
                findNavController().navigate(
                    R.id.action_authCompanySignUpNameFragment_to_authCompanySignUpIndustryFragment,
                    bundle
                )
            }
        }

    }

}
