package com.amc.common

class CommonInterface {
    var appNavigationInterface: SingleLiveEvent<AppNavigationInterface>?=null

    fun setAppNavigation(appNavigation: SingleLiveEvent<AppNavigationInterface>) {
        appNavigationInterface = appNavigation
    }

    /*Before using this method always set its value first*/
    fun getAppNavigation(): SingleLiveEvent<AppNavigationInterface>? {
        return appNavigationInterface
    }

    companion object {
         var commonInterface: CommonInterface?=null

        fun getInstance(): CommonInterface? {
            if (commonInterface == null) {
                commonInterface = CommonInterface()
            }
            return commonInterface

        }
    }
}