package com.amc.servicecall.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amc.common.BaseRowModel
import com.amc.servicecall.data.ServiceCallModel

class ServiceCallDetailsViewModel : ViewModel() {
    var serviceListLiveData: MutableLiveData<MutableList<BaseRowModel>> = MutableLiveData()

    init {
        val listService = mutableListOf<BaseRowModel>()
        listService.add(RowServiceCallViewModel(ServiceCallModel(1,true)))
        listService.add(RowServiceCallViewModel(ServiceCallModel(2,true)))
        listService.add(RowServiceCallViewModel(ServiceCallModel(3,false)))
        serviceListLiveData.value=listService

    }
}