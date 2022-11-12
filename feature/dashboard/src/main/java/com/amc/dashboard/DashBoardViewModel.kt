package com.amc.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashBoardViewModel(application: Application) : AndroidViewModel(application) {

    val isTodayList = MutableLiveData(false)
    val listVisibility = MutableLiveData(false)
    init {

    }
}