package ru.itis.kpfu.corpchat.feature.profile.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentProfileSettingBinding

class ProfileSettingFragment : Fragment(R.layout.fragment_profile_setting) {
    private val binding by viewBinding(FragmentProfileSettingBinding::bind)
    private var auth: FirebaseAuth? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth

        with(binding) {

            btSignOut.setOnClickListener {
                auth?.signOut()
                findNavController().navigate(R.id.action_profileSettingFragment_to_authEnterFragment)
            }

        }
    }

}
