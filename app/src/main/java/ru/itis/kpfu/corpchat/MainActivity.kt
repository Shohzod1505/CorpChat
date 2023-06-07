package ru.itis.kpfu.corpchat

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.itis.kpfu.corpchat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private val multiplyPermissions = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
        val isCameraGranted = it[Manifest.permission.CAMERA]
        val isReadStorageGranted = it[Manifest.permission.READ_EXTERNAL_STORAGE]
        if (isCameraGranted != true || isReadStorageGranted != true) {
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        multiplyPermissions.launch(arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE))
        val controller = (supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment).navController

        binding?.run {
            bnvMenu.setupWithNavController(controller)
        }

    }
}
