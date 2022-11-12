package com.amc.login.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amc.login.R
import com.amc.login.databinding.ActivityLoginBinding
import com.amc.login.presentation.viewmodels.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = LoginViewModel(application)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        binding.btnLogin.setOnClickListener {
            finish()
        }

    }
}