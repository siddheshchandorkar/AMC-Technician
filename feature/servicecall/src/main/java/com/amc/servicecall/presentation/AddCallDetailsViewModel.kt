package com.amc.servicecall.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amc.common.BaseRowModel
import com.amc.servicecall.data.ServiceCallModel

class AddCallDetailsViewModel : ViewModel() {
    var date: MutableLiveData<String> = MutableLiveData()

}