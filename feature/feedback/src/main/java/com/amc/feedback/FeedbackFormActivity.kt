package com.amc.feedback

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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

        binding.cvBack.setOnClickListener { finish() }

        viewModel.clearSignature.observe(this) {
            binding.signaturePad.clear()
        }
        viewModel.submit.observe(this) {
            if(it){
                val signatureBitmap: Bitmap = binding.signaturePad.signatureBitmap
                if (signatureBitmap == null) {
                    Toast.makeText(this, "Please Take Customer First to Submit Feedback", Toast.LENGTH_SHORT).show()
                } else {
                    finish()
                }
            }

        }
    }


}