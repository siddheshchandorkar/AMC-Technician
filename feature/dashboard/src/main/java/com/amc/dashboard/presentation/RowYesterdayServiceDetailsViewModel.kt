package com.amc.dashboard.presentation

import com.amc.common.BaseRowModel
import com.amc.dashboard.R
import com.amc.dashboard.data.ServiceDetailsModel

class RowYesterdayServiceDetailsViewModel(val serviceDetailsModel: ServiceDetailsModel) : BaseRowModel() {
    override fun setLayoutID() {
        layoutID = R.layout.row_yesterday_task
    }
}