package com.amc.dashboard.presentation

import com.amc.common.BaseRowModel
import com.amc.dashboard.R
import com.amc.dashboard.data.ServiceDetailsModel

class RowPendingServiceDetailsViewModel(val serviceDetailsModel: ServiceDetailsModel) : BaseRowModel() {
    override fun setLayoutID() {
        layoutID = R.layout.row_pending_task
    }
}