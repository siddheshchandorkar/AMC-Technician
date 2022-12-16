package com.amc.technician

import android.app.Application
import com.amc.common.AppNavigationInterface
import com.amc.common.CommonInterface
import com.amc.common.SingleLiveEvent
import com.amc.technician.presentation.AppNavigation

class AppController : Application() {

    override fun onCreate() {
        super.onCreate()
        CommonInterface.getInstance()?.setAppNavigation(SingleLiveEvent<AppNavigationInterface>())

        CommonInterface.getInstance()?.let {
            it.getAppNavigation()?.let { event ->
                event.observeForever { eventValue ->
                    when (eventValue) {
                        is AppNavigationInterface.NavigateToLoginActivity -> {
                            AppNavigation.navigateToLogin(eventValue.activity, false)
                        }
                        is AppNavigationInterface.NavigateToSignUpActivity -> {
                            AppNavigation.navigateToLogin(eventValue.activity, true)
                        }
                        is AppNavigationInterface.NavigateToMainActivity -> {
                            AppNavigation.navigateToMainActivity(eventValue.activity)
                        }
                        is AppNavigationInterface.NavigateToEnquiryActivity -> {
                            AppNavigation.navigateToEnquiryActivity(eventValue.activity)
                        }
                    }
                }
            }
        }
    }
}