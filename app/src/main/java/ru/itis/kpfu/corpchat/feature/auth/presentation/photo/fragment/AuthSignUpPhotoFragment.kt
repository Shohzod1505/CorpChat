package ru.itis.kpfu.corpchat.feature.auth.presentation.photo.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentAuthSignUpPhotoBinding
import ru.itis.kpfu.corpchat.feature.auth.presentation.photo.viewmodel.AuthSignUpPhotoViewModel
import ru.itis.kpfu.corpchat.utils.SharedPreferences.APP_PREFERENCES
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_COMPANY_ID
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_EMAIL
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_USER_ID
import ru.itis.kpfu.corpchat.utils.hide
import javax.inject.Inject

class AuthSignUpPhotoFragment : DaggerFragment(R.layout.fragment_auth_sign_up_photo) {
    private val binding by viewBinding(FragmentAuthSignUpPhotoBinding::bind)
    private var storageRef: StorageReference? = null
    private var databaseRef: DatabaseReference? = null
    private var preferences: SharedPreferences? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AuthSignUpPhotoViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

        hide(R.id.bnv_menu)
        hide(R.id.toolbar)

        with(binding) {
            val companyId = preferences?.getString(PREF_COMPANY_ID, null)
            val userId = preferences?.getString(PREF_USER_ID, null)
            val email = preferences?.getString(PREF_EMAIL, "error")

            if (companyId != null) {
                databaseRef = FirebaseDatabase.getInstance().getReference("Company").child(companyId)
                storageRef = FirebaseStorage.getInstance().getReference("Company")
                    .child(companyId).child("images/ava.jpg")
            }
            if (userId != null) {
                databaseRef = FirebaseDatabase.getInstance().getReference("User").child(userId)
                storageRef = FirebaseStorage.getInstance().getReference("User")
                    .child(userId).child("images/ava.jpg")
            }

            ivbtAddLogo.setOnClickListener {
                openGallery()
            }

            btNext.setOnClickListener {
                findNavController().navigate(R.id.action_authSignUpPhotoFragment_to_newsFeedFragment,)
            }

        }
    }

    private fun openGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri = data.data
            val bitmap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, imageUri)
            if (imageUri != null) {
                val hashMap: HashMap<String, Any> = HashMap()
                val uploadTask = storageRef?.putFile(imageUri)
                uploadTask?.addOnSuccessListener { taskSnapshot ->
                    val downloadUrl = taskSnapshot.metadata?.reference?.downloadUrl.toString()
                    hashMap["image"] = downloadUrl
                    databaseRef?.updateChildren(hashMap)
                    show(bitmap)
                }?.addOnFailureListener { exception ->
                }
            }
        }
    }

    private fun show(bitmap: Bitmap) {
        val iv = binding.ivbtAddLogo
        iv.setPadding(0,0,0,0)
        Glide.with(this)
            .load(bitmap)
            .centerCrop()
            .transform(CircleCrop())
            .into(iv)
    }


    companion object {
        const val PICK_IMAGE_REQUEST = 1
    }

}
