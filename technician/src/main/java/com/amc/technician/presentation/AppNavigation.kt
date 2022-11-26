package com.amc.technician.presentation

import android.app.Activity
import android.content.Intent
import com.amc.login.presentation.ui.LoginActivity
import com.amc.technician.R
import com.amc.technician.presentation.ui.MainActivity

class AppNavigation {

    companion object {
        fun navigateToLogin(activity: Activity,isSignUp:Boolean) {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.putExtra(LoginActivity.LOGIN_OR_SIGNUP,isSignUp)
            activity.startActivity(intent)
        }

        fun navigateToMainActivity(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
            activity.finish()
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