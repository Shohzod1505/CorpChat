package ru.itis.kpfu.corpchat.feature.auth.presentation.photo.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthSignUpPhotoBinding
import ru.itis.kpfu.corpchat.feature.auth.presentation.photo.viewmodel.AuthSignUpPhotoViewModel
import javax.inject.Inject

class AuthSignUpPhotoFragment : DaggerFragment(R.layout.fragment_auth_sign_up_photo) {
    private val binding by viewBinding(FragmentAuthSignUpPhotoBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthSignUpPhotoViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btNext.setOnClickListener {
                findNavController().navigate(R.id.action_authSignUpPhotoFragment_to_newsFeedFragment)
            }
        }
    }

}
