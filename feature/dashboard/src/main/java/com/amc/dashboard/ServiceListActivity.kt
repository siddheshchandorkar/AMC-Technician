package com.amc.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amc.dashboard.databinding.ActivityServiceListBinding

class ServiceListActivity : AppCompatActivity() {
    private lateinit var viewModel: ServiceListViewModel
    private lateinit var binding: ActivityServiceListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service_list)
        var serviceType=0

        intent.extras?.let {
            if(it.containsKey(SERVICE_TYPE)){
                serviceType=it.getInt(SERVICE_TYPE,0)
            }
        }
        viewModel = ServiceListViewModel(application,serviceType)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        binding.cvBack.setOnClickListener { finish() }
    }

    companion object{
        const val SERVICE_TYPE="service_type"
    }

}