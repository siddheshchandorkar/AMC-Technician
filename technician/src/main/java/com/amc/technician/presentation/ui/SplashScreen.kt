package com.amc.technician.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.amc.common.AppNavigationInterface
import com.amc.common.BaseActivity
import com.amc.common.CommonInterface
import com.amc.common.SingleLiveEvent
import com.amc.technician.R
import com.amc.technician.databinding.ActivitySplashBinding
import com.amc.technician.presentation.AppNavigation

class SplashScreen : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        CommonInterface.getInstance()?.setAppNavigation(SingleLiveEvent<AppNavigationInterface>())
        binding.btnLogin.setOnClickListener {
            callLoginOrSignUp(true)
        }
        binding.tvSignup.setOnClickListener {
            callLoginOrSignUp(false)
        }

        CommonInterface.getInstance()?.let {
            it.getAppNavigation()?.let { event ->
                event.observe(this) { eventValue ->
                    when (eventValue) {
                        is AppNavigationInterface.NavigateToLoginActivity -> {
                            AppNavigation.navigateToLogin(this, false)
                        }
                        is AppNavigationInterface.NavigateToSignUpActivity -> {
                            AppNavigation.navigateToLogin(this, true)
                        }
                        is AppNavigationInterface.NavigateToMainActivity -> {
                            AppNavigation.navigateToMainActivity(this)
                        }
                    }
                }
            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        CommonInterface.getInstance()?.let {
            it.getAppNavigation()?.let { liveEvent ->
                liveEvent.value = AppNavigationInterface.NavigateToMainActivity(this)

            }
        }
    }

    private fun callLoginOrSignUp(isLogin: Boolean) {
        CommonInterface.getInstance()?.let {
            it.getAppNavigation()?.let { liveEvent ->
                if (isLogin) {
                    liveEvent.value = AppNavigationInterface.NavigateToLoginActivity(this)
//                   liveEvent.value =AppNavigationInterface.NavigateToMainActivity(this)
                } else {
                    liveEvent.value = AppNavigationInterface.NavigateToSignUpActivity(this)
                }
            }
        }
    }

}