package ru.itis.kpfu.corpchat.feature.profile.presentation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentProfileSettingBinding
import ru.itis.kpfu.corpchat.utils.SharedPreferences.APP_PREFERENCES
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_COMPANY_ID
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_EMAIL
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_USER_ID

class ProfileSettingFragment : Fragment(R.layout.fragment_profile_setting) {
    private val binding by viewBinding(FragmentProfileSettingBinding::bind)
    private var auth: FirebaseAuth? = null
    private var preferences: SharedPreferences? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        auth = Firebase.auth

        with(binding) {

            btSignOut.setOnClickListener {
                auth?.signOut()
                preferences?.edit {
                    putString(PREF_COMPANY_ID, null)
                    putString(PREF_USER_ID, null)
                    putString(PREF_EMAIL, null)
                    commit()
                }
                findNavController().navigate(R.id.action_profileSettingFragment_to_authEnterFragment)
            }

        }
    }

}
