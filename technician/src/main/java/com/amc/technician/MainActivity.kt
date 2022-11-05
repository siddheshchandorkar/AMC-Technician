package com.amc.technician

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amc.technician.presentation.AppNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppNavigation.navigateToDashboard(this)
        finish()
    }
}