package ru.itis.kpfu.corpchat.presentation.screen.auth.photo.fragment;

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthSignUpPhotoBinding
import ru.itis.kpfu.corpchat.presentation.screen.auth.photo.viewmodel.AuthSignUpPhotoViewModel
import javax.inject.Inject

class AuthSignUpPhotoFragment : DaggerFragment(R.layout.fragment_auth_sign_up_photo) {
    private var binding: FragmentAuthSignUpPhotoBinding? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthSignUpPhotoViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthSignUpPhotoBinding.bind(view)

        binding?.run {
            btNext.setOnClickListener {
                findNavController().navigate(R.id.action_authSignUpPhotoFragment_to_newsFeedFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
