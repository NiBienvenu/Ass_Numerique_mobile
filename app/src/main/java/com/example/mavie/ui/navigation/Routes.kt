package com.example.mavie.ui.navigation

object Graph {
    const val MainScreenGraph = "mainScreenGraph"
}

sealed class MainRouteScreen(val route: String) {
    object Home : MainRouteScreen("home")
    object Create : MainRouteScreen("create")
    object Edit : MainRouteScreen("edit")
    object Setting : MainRouteScreen("setting")
}

sealed class NewsRouteScreen(val route: String) {
    object NewsDetail : NewsRouteScreen("newsDetail")
}

sealed class SettingRouteScreen(val route: String) {
    object SettingDetail : SettingRouteScreen("settingDetail")
}
