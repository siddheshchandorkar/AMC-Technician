package com.amc.servicecall.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amc.common.BaseRowModel
import com.amc.servicecall.data.ServiceCallModel

class ServiceCallDetailsViewModel : ViewModel() {
    var serviceListLiveData: MutableLiveData<MutableList<BaseRowModel>> = MutableLiveData()

    init {
        val listService = mutableListOf<BaseRowModel>()
        listService.add(RowServiceCallViewModel(ServiceCallModel(1,true,"10:10","11:11")))
        listService.add(RowServiceCallViewModel(ServiceCallModel(2,false,"","")))
//        listService.add(RowServiceCallViewModel(ServiceCallModel(3,false,"","")))
        serviceListLiveData.value=listService
    }
}