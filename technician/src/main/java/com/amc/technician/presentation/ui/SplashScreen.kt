package com.amc.technician.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amc.common.AppNavigationInterface
import com.amc.common.CommonInterface
import com.amc.technician.R
import com.amc.technician.databinding.ActivitySplashBinding
import com.amc.technician.presentation.AppNavigation

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        binding.btnLogin.setOnClickListener {
            CommonInterface.getInstance().getAppNavigation().value =AppNavigationInterface.NavigateToLoginActivity
//            AppNavigation.navigateToLogin(this,false)
        }
        binding.tvSignup.setOnClickListener {
//            AppNavigation.navigateToLogin(this,true)
            CommonInterface.getInstance().getAppNavigation().value =AppNavigationInterface.NavigateToSignUpActivity

        }

//        CommonInterface.getInstance().getAppNavigation().observe(this) {
//            when (it) {
//                AppNavigationInterface.NavigateToLoginActivity -> {
//                    AppNavigation.navigateToLogin(this, false)
//                }
//                AppNavigationInterface.NavigateToSignUpActivity -> {
//                    AppNavigation.navigateToLogin(this, true)
//                }
//                AppNavigationInterface.NavigateToMainActivity -> {
//                    AppNavigation.navigateToMainActivity(this)
//                }
//            }
//        }


    }

}