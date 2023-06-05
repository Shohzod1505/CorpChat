package ru.itis.kpfu.corpchat.feature.auth.presentation.company.industry.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthCompanySignUpIndustryBinding
import ru.itis.kpfu.corpchat.feature.auth.presentation.company.industry.viewmodel.AuthCompanySignUpIndustryViewModel
import java.util.HashMap
import javax.inject.Inject

class AuthCompanySignUpIndustryFragment : DaggerFragment(R.layout.fragment_auth_company_sign_up_industry) {
    private var binding: FragmentAuthCompanySignUpIndustryBinding? = null
    private var dbReference: DatabaseReference? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthCompanySignUpIndustryViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthCompanySignUpIndustryBinding.bind(view)

        binding?.run {

            val industry = arrayListOf<String>()
            val checkBoxes = arrayOf(chB1, chB2, chB3, chB4, chB5, chB6, chB7, chB8, chB9, chB10)

            val userId = arguments?.getString("companyId")
            if (userId != null) {
                dbReference = FirebaseDatabase.getInstance().getReference("Company").child(userId)
            }
            val hashMap: HashMap<String, Any> = HashMap()

            btNext.setOnClickListener {

                for (checkBox in checkBoxes) {
                    if (checkBox.isChecked) {
                        industry.add(checkBox.text.toString())
                    }
                }

                hashMap["industry"] = industry
                dbReference?.updateChildren(hashMap)
                findNavController().navigate(R.id.action_authCompanySignUpIndustryFragment_to_authSignUpPhotoFragment)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
