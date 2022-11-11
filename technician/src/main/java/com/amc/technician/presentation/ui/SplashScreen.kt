package com.amc.technician.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amc.login.presentation.ui.LoginActivity
import com.amc.technician.databinding.ActivityMainBinding
import com.amc.technician.presentation.AppNavigation
import com.amc.technician.presentation.viewmodel.MainActivityViewModel

class SplashScreen : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivityForResult(Intent(this,LoginActivity::class.java), 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        AppNavigation.navigateToMainActivity(this)
    }
}