package com.amc.dashboard

import android.app.AlertDialog
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.amc.common.BaseActivity
import com.amc.dashboard.databinding.ActivityServiceListBinding

class ServiceListActivity : BaseActivity() {
    private lateinit var viewModel: ServiceListViewModel
    private lateinit var binding: ActivityServiceListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service_list)
        var serviceType = 0

        intent.extras?.let {
            if (it.containsKey(SERVICE_TYPE)) {
                serviceType = it.getInt(SERVICE_TYPE, 0)
            }
        }
        viewModel = ServiceListViewModel(application, serviceType)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        binding.cvBack.setOnClickListener { finish() }

        viewModel.showFiler.observe(this) {

            if (it) {

                val builder = AlertDialog.Builder(this)
                    .create()
                val view = layoutInflater.inflate(R.layout.dialog_task_filter, null)
                val buttonCancel = view.findViewById<TextView>(R.id.tv_cancel)
                val buttonFilter = view.findViewById<TextView>(R.id.tv_filter)
                builder.window?.setBackgroundDrawableResource(android.R.color.transparent)

                builder.setView(view)
                buttonCancel.setOnClickListener {
                    builder.dismiss()
                }
                buttonFilter.setOnClickListener {
                    builder.dismiss()
                }
                builder.show()
            }
        }
    }

    companion object {
        const val SERVICE_TYPE = "service_type"
    }

}