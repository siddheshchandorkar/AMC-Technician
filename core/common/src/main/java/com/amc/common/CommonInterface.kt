package com.amc.common

class CommonInterface {
    lateinit var appNavigationInterface: SingleLiveEvent<AppNavigationInterface>

    fun setAppNavigation(appNavigation: SingleLiveEvent<AppNavigationInterface>) {
        appNavigationInterface = appNavigation
    }

    fun getAppNavigation(): SingleLiveEvent<AppNavigationInterface> {
        return appNavigationInterface
    }

    companion object {
        lateinit var commonInterface: CommonInterface

        fun getInstance(): CommonInterface {
            if (commonInterface == null) {
                commonInterface = CommonInterface()
            }
            return commonInterface

        }
    }
}