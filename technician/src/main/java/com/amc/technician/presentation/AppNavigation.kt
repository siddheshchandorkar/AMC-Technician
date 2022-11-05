package com.amc.technician.presentation

import android.app.Activity
import android.content.Intent
import com.amc.dashboard.DashBoardActivity
import com.amc.login.presentation.ui.LoginActivity

class AppNavigation {

    companion object {
        fun navigateToLogin(activity: Activity) {
            val intent = Intent(activity, LoginActivity::class.java)
            activity.startActivity(intent)
        }

        fun navigateToDashboard(activity: Activity) {
            val intent = Intent(activity, DashBoardActivity::class.java)
            activity.startActivity(intent)
        }
    }


}