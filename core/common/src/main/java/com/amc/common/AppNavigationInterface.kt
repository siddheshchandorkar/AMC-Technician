package com.amc.common

sealed class AppNavigationInterface{
    object NavigateToMainActivity : AppNavigationInterface()
    object NavigateToLoginActivity : AppNavigationInterface()
    object NavigateToSignUpActivity : AppNavigationInterface()
}