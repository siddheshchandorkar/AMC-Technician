package com.amc.dashboard.presentation

import com.amc.common.BaseRowModel
import com.amc.dashboard.R
import com.amc.dashboard.data.ServiceDetailsModel

class RowThisWeekServiceDetailsViewModel(val serviceDetailsModel: ServiceDetailsModel):BaseRowModel() {
    override fun setLayoutID() {
            R.layout.row_this_week_task
    }
}