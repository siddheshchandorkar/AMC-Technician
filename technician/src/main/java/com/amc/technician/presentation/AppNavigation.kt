package com.amc.technician.presentation

import android.app.Activity
import android.content.Intent
import com.amc.enquiry.AddEnquiryActivity
import com.amc.feedback.FeedbackFormActivity
import com.amc.login.presentation.ui.LoginActivity
import com.amc.servicecall.AddCallDetailsActivity
import com.amc.servicecall.ServiceCallDetailsActivity
import com.amc.technician.presentation.ui.MainActivity

class AppNavigation {

    companion object {
        fun navigateToLogin(activity: Activity, isSignUp: Boolean) {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.putExtra(LoginActivity.LOGIN_OR_SIGNUP, isSignUp)
            activity.startActivityForResult(intent, LoginActivity.LOGIN_CODE)
        }

        fun navigateToMainActivity(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
            activity.finish()
        }

        fun navigateToEnquiryActivity(activity: Activity) {
            val intent = Intent(activity, AddEnquiryActivity::class.java)
            activity.startActivity(intent)
        }

        fun navigateToFeedbackActivity(activity: Activity) {
            val intent = Intent(activity, FeedbackFormActivity::class.java)
            activity.startActivity(intent)
        }

        fun navigateToServiceCallDetailsActivity(activity: Activity) {
            val intent = Intent(activity, ServiceCallDetailsActivity::class.java)
            activity.startActivity(intent)
        }

        fun navigateToAddCallDetailsActivity(activity: Activity) {
            val intent = Intent(activity, AddCallDetailsActivity::class.java)
            activity.startActivity(intent)
        }
    }


}