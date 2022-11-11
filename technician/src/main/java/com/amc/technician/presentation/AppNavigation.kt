package com.amc.technician.presentation

import android.app.Activity
import android.content.Intent
import com.amc.login.presentation.ui.LoginActivity
import com.amc.technician.R

class AppNavigation {

    companion object {
        fun navigateToLogin(activity: Activity) {
            val intent = Intent(activity, LoginActivity::class.java)
            activity.startActivity(intent)
        }

        fun navigateToDashboard(activity: Activity) {
//            val transaction = activity.s.beginTransaction()
//            transaction.replace(R.id.containter, fragment)
//            transaction.commit()
//            val intent = Intent(activity, DashBoardActivity::class.java)
//            activity.startActivity(intent)
        }
    }


}