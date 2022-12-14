package com.amc.leaderboard.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amc.common.BaseRowModel
import com.amc.leaderboard.domain.model.LeaderBoardModel

class LeaderBoardViewModel(application: Application) : AndroidViewModel(application) {

    var first =MutableLiveData("Ramesh")
    var second =MutableLiveData("Suresh")
    var third =MutableLiveData("Mahesh")
    var technicianListLiveData: MutableLiveData<MutableList<BaseRowModel>> = MutableLiveData()

    init {
        val listTechnician = mutableListOf<BaseRowModel>()
        listTechnician.add(
            RowLeaderBoardViewModel(
                LeaderBoardModel(
                    4,"Rahul Sharma",30
                )
            )
        )
        listTechnician.add(
            RowLeaderBoardViewModel(
                LeaderBoardModel(
                    4,"Girish Phalake",25
                )
            )
        )
         listTechnician.add(
            RowLeaderBoardViewModel(
                LeaderBoardModel(
                    4,"Sujay Angunde",20
                )
            )
        )

        technicianListLiveData.value = listTechnician
    }
}