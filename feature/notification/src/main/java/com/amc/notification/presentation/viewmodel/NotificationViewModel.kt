package com.amc.notification.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.amc.common.BaseRowModel
import com.amc.notification.domain.model.NotificationModel

class NotificationViewModel(application: Application) : AndroidViewModel(application) {
    var notificationListLiveData: MutableLiveData<MutableList<BaseRowModel>> = MutableLiveData()

    init {
        val listNotification = mutableListOf<BaseRowModel>()
        listNotification.add(
            RowNotificationViewModel(
                NotificationModel(
                    "Amar Singh for AC Repairing On 22-Nov-2022 at 11:00AM",
                    "505-Unity Heights, Kalyan West"
                )
            )
        )
        listNotification.add(
            RowNotificationViewModel(
                NotificationModel(
                    "Amar Singh for AC Repairing On 22-Nov-2022 at 11:00AM",
                    "505-Unity Heights, Kalyan West"
                )
            )
        )
        listNotification.add(
            RowNotificationViewModel(
                NotificationModel(
                    "Amar Singh for AC Repairing On 22-Nov-2022 at 11:00AM",
                    "505-Unity Heights, Kalyan West"
                )
            )
        )
        notificationListLiveData.value = listNotification
    }
}