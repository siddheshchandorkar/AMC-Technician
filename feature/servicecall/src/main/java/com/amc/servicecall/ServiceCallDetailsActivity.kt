package com.amc.servicecall

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amc.servicecall.databinding.ActivityAddServiceCallBinding
import com.amc.servicecall.presentation.ServiceCallDetailsViewModel

class ServiceCallDetailsActivity : AppCompatActivity() {
    private lateinit var viewModel: ServiceCallDetailsViewModel
    private lateinit var binding: ActivityAddServiceCallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_service_call)
        viewModel = ServiceCallDetailsViewModel()
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}