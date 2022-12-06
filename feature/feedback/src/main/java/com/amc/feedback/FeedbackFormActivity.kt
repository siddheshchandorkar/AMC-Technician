package com.amc.feedback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amc.common.AppNavigationInterface
import com.amc.feedback.databinding.ActivityFeedbackFormBinding
import com.amc.feedback.presentation.FeedBackFormViewModel

class FeedbackFormActivity : AppCompatActivity() {
    private lateinit var viewModel: FeedBackFormViewModel
    private lateinit var binding: ActivityFeedbackFormBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feedback_form)
        viewModel = FeedBackFormViewModel()
        binding.vm = viewModel
        binding.lifecycleOwner = this

    }

}