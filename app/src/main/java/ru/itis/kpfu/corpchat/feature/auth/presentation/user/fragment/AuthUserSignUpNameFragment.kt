package ru.itis.kpfu.corpchat.feature.auth.presentation.user.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthUserSignUpNameBinding
import ru.itis.kpfu.corpchat.utils.getTextAsString
import java.util.HashMap

class AuthUserSignUpNameFragment : Fragment(R.layout.fragment_auth_user_sign_up_name) {
    private var binding: FragmentAuthUserSignUpNameBinding? = null
    private var dbReference: DatabaseReference? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthUserSignUpNameBinding.bind(view)

        binding?.run {

            val userId = arguments?.getString("userId")
            if (userId != null) {
                dbReference = FirebaseDatabase.getInstance().getReference("User").child(userId)
            }
            val hashMap: HashMap<String, Any> = HashMap()

            btNext.setOnClickListener {
                hashMap["name"] = etName.getTextAsString()
                hashMap["lastName"] = etLastName.getTextAsString()
                hashMap["phone"] = etPhone.getTextAsString()
                hashMap["company"] = etCompany.getTextAsString()
                dbReference?.updateChildren(hashMap)
                findNavController().navigate(R.id.action_authUserSignUpNameFragment_to_authSignUpPhotoFragment)
           }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
