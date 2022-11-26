package com.amc.technician.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amc.technician.R
import com.amc.technician.databinding.ActivitySplashBinding
import com.amc.technician.presentation.AppNavigation

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        binding.btnLogin.setOnClickListener {
            AppNavigation.navigateToLogin(this,false)
        }
        binding.tvSignup.setOnClickListener {
            AppNavigation.navigateToLogin(this,true)
        }
    }

}