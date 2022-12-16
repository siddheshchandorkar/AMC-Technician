package com.amc.enquiry

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amc.common.BaseActivity
import com.amc.enquiry.databinding.ActivityAddEnquiryBinding

class AddEnquiryActivity : BaseActivity() {
    private lateinit var binding: ActivityAddEnquiryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_enquiry)
        binding.cvBack.setOnClickListener { finish() }
    }
}