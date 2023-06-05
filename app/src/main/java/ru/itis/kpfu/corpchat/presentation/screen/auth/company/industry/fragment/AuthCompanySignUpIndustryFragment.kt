package ru.itis.kpfu.corpchat.presentation.screen.auth.company.industry.fragment;

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
import ru.itis.kpfu.corpchat.presentation.screen.auth.company.industry.viewmodel.AuthCompanySignUpIndustryViewModel
import ru.itis.kpfu.corpchat.utils.convert
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

            val userId = arguments?.getString("companyId")
            if (userId != null) {
                dbReference = FirebaseDatabase.getInstance().getReference("Company").child(userId)
            }
            val hashMap: HashMap<String, Any> = HashMap()

            btNext.setOnClickListener {

                hashMap["industry"] = ""
                dbReference?.updateChildren(hashMap)
                findNavController().navigate(R.id.action_authCompanySignUpIndustryFragment_to_authSignUpPhotoFragment)
            }
        }

    }

    private fun chooseIndustry() {
        binding?.run {
//            when{
//                checkBox1.isChecked -> {
//
//                }
//                checkBox2.isChecked -> {
//
//                }
//                checkBox3.isChecked -> {
//
//                }
//                checkBox4.isChecked -> {
//
//                }
//                checkBox5.isChecked -> {
//
//                }
//                checkBox6.isChecked -> {
//
//                }
//                checkBox7.isChecked -> {
//
//                }
//                checkBox8.isChecked -> {
//
//                }
//                checkBox9.isChecked -> {
//
//                }
//                checkBox10.isChecked -> {
//
//                }
//            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
