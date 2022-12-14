package com.amc.leaderboard.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.amc.common.BaseRowModel
import com.amc.leaderboard.R
import com.amc.leaderboard.domain.model.LeaderBoardModel

class RowLeaderBoardViewModel(leaderBoardModel: LeaderBoardModel) :BaseRowModel() {
    val rank = MutableLiveData(leaderBoardModel.rank.toString())
    val technicianName = MutableLiveData(leaderBoardModel.technicianName.toString())
    val score = MutableLiveData(leaderBoardModel.score.toString())
    override fun setLayoutID() {
        layoutID= R.layout.row_leader_board
    }
}