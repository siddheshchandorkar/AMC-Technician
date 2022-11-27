package com.amc.common

import android.app.Activity

sealed class AppNavigationInterface{
    class NavigateToMainActivity(var activity: Activity) : AppNavigationInterface()
    class NavigateToLoginActivity(var activity: Activity) : AppNavigationInterface()
    class NavigateToSignUpActivity(var activity: Activity) : AppNavigationInterface()
}