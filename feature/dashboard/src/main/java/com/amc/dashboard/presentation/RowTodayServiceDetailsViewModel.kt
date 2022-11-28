package com.amc.dashboard.presentation

import com.amc.common.BaseRowModel
import com.amc.dashboard.R
import com.amc.dashboard.data.ServiceDetailsModel

class RowTodayServiceDetailsViewModel(val serviceDetailsModel: ServiceDetailsModel) : BaseRowModel() {
    override fun setLayoutID() {
        layoutID = R.layout.row_today_task
    }
}