package com.amc.technician.presentation.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.amc.common.AppNavigationInterface
import com.amc.common.BaseActivity
import com.amc.common.CommonInterface
import com.amc.common.Constant.Companion.MOVE_TO_LOGIN
import com.amc.common.Constant.Companion.MOVE_TO_MAIN
import com.amc.common.SingleLiveEvent
import com.amc.login.presentation.ui.LoginActivity
import com.amc.technician.R
import com.amc.technician.databinding.ActivitySplashBinding
import com.amc.technician.presentation.AppNavigation

class SplashScreen : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
//        CommonInterface.getInstance()?.setAppNavigation(SingleLiveEvent<AppNavigationInterface>())
        binding.btnLogin.setOnClickListener {
            val intent = Intent(MOVE_TO_LOGIN)
            intent.putExtra(LoginActivity.LOGIN_OR_SIGNUP, false)
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }
        binding.tvSignup.setOnClickListener {
            val intent = Intent(MOVE_TO_LOGIN)
            intent.putExtra(LoginActivity.LOGIN_OR_SIGNUP, true)
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
            //            callLoginOrSignUp(false)
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

    override fun onResume() {
        super.onResume()
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(loginBroadCastReceiver, IntentFilter(MOVE_TO_LOGIN))
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(mainBroadCastReceiver, IntentFilter(MOVE_TO_MAIN))
    }

    override fun onStop() {
        super.onStop()
        LocalBroadcastManager.getInstance(this)
            .unregisterReceiver(loginBroadCastReceiver)
        LocalBroadcastManager.getInstance(this)
            .unregisterReceiver(mainBroadCastReceiver)
    }

    private val loginBroadCastReceiver = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context, intent: Intent) {
            when (intent.action) {
                MOVE_TO_LOGIN -> {
                    var isLogin =true
                    intent.extras?.let {
                        if(it.containsKey(LoginActivity.LOGIN_OR_SIGNUP)){
                           isLogin=it.getBoolean(LoginActivity.LOGIN_OR_SIGNUP,false)
                        }
                    }
                    AppNavigation.navigateToLogin(this@SplashScreen, isLogin)
                }
            }
        }
    }

    private val mainBroadCastReceiver = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context, intent: Intent) {
            when (intent.action) {
                MOVE_TO_MAIN -> {
                    AppNavigation.navigateToMainActivity(this@SplashScreen)
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