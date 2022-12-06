package com.amc.login.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(val app: Application) : AndroidViewModel(app) {

    var isSignUp =MutableLiveData<Boolean>()
    var isForwardPassword =MutableLiveData(false)

    fun forgotPassword(){
        isForwardPassword.value=true
    }

}