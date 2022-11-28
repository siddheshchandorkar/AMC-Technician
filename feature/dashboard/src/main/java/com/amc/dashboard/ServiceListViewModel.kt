package com.amc.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.amc.common.BaseRowModel
import com.amc.dashboard.data.ServiceDetailsModel
import com.amc.dashboard.presentation.*

class ServiceListViewModel(application: Application, private val serviceFilterType:Int) : AndroidViewModel(application) {

    var serviceListLiveData: MutableLiveData<MutableList<BaseRowModel>> = MutableLiveData()

    init {
        val listService = mutableListOf<BaseRowModel>()
        when(serviceFilterType){
            0->{
                listService.add(RowTomorrowServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTomorrowServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTomorrowServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTomorrowServiceDetailsViewModel(ServiceDetailsModel()))
            }
            1->{
                listService.add(RowYesterdayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowYesterdayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowYesterdayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowYesterdayServiceDetailsViewModel(ServiceDetailsModel()))
            }
            2->{
                listService.add(RowThisWeekServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowThisWeekServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowThisWeekServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowThisWeekServiceDetailsViewModel(ServiceDetailsModel()))
            }
            3->{
                listService.add(RowPendingServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowPendingServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowPendingServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowPendingServiceDetailsViewModel(ServiceDetailsModel()))
            }
            4->{
                listService.add(RowTodayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTodayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTodayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTodayServiceDetailsViewModel(ServiceDetailsModel()))

            }
        }

        serviceListLiveData.value= listService
    }
}