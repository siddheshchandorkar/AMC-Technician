package com.amc.servicecall.presentation

import androidx.databinding.ObservableField
import com.amc.common.BaseRowModel
import com.amc.servicecall.R
import com.amc.servicecall.data.ServiceCallModel

class RowServiceCallViewModel(val serviceCallModel: ServiceCallModel) : BaseRowModel() {
    var srNo =ObservableField(serviceCallModel.srNo)
    var isVerified =ObservableField(serviceCallModel.verified)
    override fun setLayoutID() {
        layoutID = R.layout.row_service_call
    }
}