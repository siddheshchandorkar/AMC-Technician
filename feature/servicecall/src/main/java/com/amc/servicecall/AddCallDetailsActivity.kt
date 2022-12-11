package com.amc.servicecall

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amc.common.BaseActivity
import com.amc.servicecall.databinding.ActivityAddCallDetailsBinding
import com.amc.servicecall.presentation.AddCallDetailsViewModel
import com.takisoft.datetimepicker.DatePickerDialog
import java.util.*


class AddCallDetailsActivity : BaseActivity() {
    private lateinit var viewModel: AddCallDetailsViewModel
    private lateinit var binding: ActivityAddCallDetailsBinding
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_call_details)
        binding.lifecycleOwner = this
        viewModel= AddCallDetailsViewModel()
        binding.vm = viewModel

        binding.cvBack.setOnClickListener { finish() }
        binding.btnSubmit.setOnClickListener { finish() }
        binding.etDate.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                { view1, year, month, dayOfMonth ->
                    viewModel.date.value=java.lang.String.format("%d", year).toString() + "-" + String.format(
                        "%02d",
                        month + 1
                    ) + "-" + java.lang.String.format("%02d", dayOfMonth)

                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DATE)
            )
            dpd.show()
        }
    }

}