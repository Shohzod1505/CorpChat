package ru.itis.kpfu.corpchat.feature.news.presentation.edit.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference
import dagger.android.support.DaggerFragment
import ru.itis.kpfu.corpchat.R
import ru.itis.kpfu.corpchat.databinding.FragmentNewsEditBinding
import ru.itis.kpfu.corpchat.feature.news.presentation.edit.viewmodel.NewsEditViewModel
import ru.itis.kpfu.corpchat.utils.SharedPreferences.APP_PREFERENCES
import ru.itis.kpfu.corpchat.utils.SharedPreferences.PREF_USER_ID
import ru.itis.kpfu.corpchat.utils.getTextAsString
import javax.inject.Inject

class NewsEditFragment : DaggerFragment(R.layout.fragment_news_edit) {
    private val binding by viewBinding(FragmentNewsEditBinding::bind)
    private var storageRef: StorageReference? = null
    private var databaseRef: DatabaseReference? = null
    private var preferences: SharedPreferences? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: NewsEditViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

        with(binding) {

                findNavController().navigate(R.id.action_authEnterFragment_to_authSignInFragmet)


            val userId = preferences?.getString(PREF_USER_ID, null)

            ivbtAddNews.setOnClickListener {
                openGallery()
            }

            btSave.setOnClickListener {
                val title = etTitle.getTextAsString()
                val text = etText.getTextAsString()
                viewModel.shareNews(title, text, userId)
                findNavController().navigate(R.id.action_newsEditFragment_to_newsFeedFragment)
            }

        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            url.observe(viewLifecycleOwner) {
                show(it)
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
                val uploadTask = storageRef?.putFile(imageUri)
                uploadTask?.addOnSuccessListener { taskSnapshot ->
                    val downloadUrl = taskSnapshot.metadata?.reference?.downloadUrl.toString()
                    viewModel.loadImage(downloadUrl)
                }?.addOnFailureListener { exception ->
                }
            }
        }
    }

    private fun show(url: String) {
        val iv = binding.ivbtAddNews
        iv.setPadding(0,0,0,0)
        Glide.with(this)
            .load(url)
            .centerCrop()
            .into(iv)
    }

    companion object {
        const val PICK_IMAGE_REQUEST = 2
    }

}
