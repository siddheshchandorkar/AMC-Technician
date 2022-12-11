package com.amc.servicecall

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amc.common.BaseActivity
import com.amc.servicecall.databinding.ActivityServiceCallDetailsBinding
import com.amc.servicecall.presentation.ServiceCallDetailsViewModel

class ServiceCallDetailsActivity : BaseActivity() {
    private lateinit var viewModel: ServiceCallDetailsViewModel
    private lateinit var binding: ActivityServiceCallDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service_call_details)
        viewModel = ServiceCallDetailsViewModel()
        binding.vm = viewModel
        binding.lifecycleOwner = this

        binding.cvBack.setOnClickListener { finish() }

        binding.btnAddService.setOnClickListener {
            startActivity(Intent(this, AddCallDetailsActivity::class.java))
        }
    }

}