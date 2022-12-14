package com.amc.notification.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.amc.common.BaseRowModel
import com.amc.notification.R
import com.amc.notification.domain.model.NotificationModel

class RowNotificationViewModel(notificationModel: NotificationModel) :
    BaseRowModel() {
    var title = MutableLiveData(notificationModel.title)
    var subTitle = MutableLiveData(notificationModel.subTitle)
    override fun setLayoutID() {
        layoutID = R.layout.row_notification
    }

}