package com.amc.technician

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amc.dashboard.DashBoardActivity
import com.amc.login.presentation.ui.LoginActivity
import com.amc.technician.presentation.AppNavigation
import kotlinx.coroutines.CoroutineScope

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppNavigation.navigateToLogin(this)
        finish()
    }
}