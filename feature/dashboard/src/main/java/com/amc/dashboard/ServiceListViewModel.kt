package com.amc.dashboard

import android.app.AlertDialog
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.amc.common.BaseRowModel
import com.amc.dashboard.data.ServiceDetailsModel
import com.amc.dashboard.presentation.*

class ServiceListViewModel(application: Application, private val serviceFilterType:Int) : AndroidViewModel(application) {

    var serviceListLiveData: MutableLiveData<MutableList<BaseRowModel>> = MutableLiveData()
    var title: MutableLiveData<String> = MutableLiveData()
    var showFiler=MutableLiveData(false)

    init {
        val listService = mutableListOf<BaseRowModel>()
        when(serviceFilterType){
            0->{
                listService.add(RowTomorrowServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTomorrowServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTomorrowServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTomorrowServiceDetailsViewModel(ServiceDetailsModel()))
                title.value="Tomorrow's Task"
            }
            1->{
                listService.add(RowYesterdayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowYesterdayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowYesterdayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowYesterdayServiceDetailsViewModel(ServiceDetailsModel()))
                title.value="Yesterday's Task"
            }
            2->{
                listService.add(RowThisWeekServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowThisWeekServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowThisWeekServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowThisWeekServiceDetailsViewModel(ServiceDetailsModel()))
                title.value="This Week's Task"
            }
            3->{
                listService.add(RowPendingServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowPendingServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowPendingServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowPendingServiceDetailsViewModel(ServiceDetailsModel()))
                title.value="Pending Task"
            }
            4->{
                listService.add(RowTodayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTodayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTodayServiceDetailsViewModel(ServiceDetailsModel()))
                listService.add(RowTodayServiceDetailsViewModel(ServiceDetailsModel()))
                title.value="Today's Task"

            }
        }

        serviceListLiveData.value= listService
    }

    fun showFilterOption(){
        showFiler.value=true
    }
}