package com.example.mavie.ui.navigation

object Graph {
    const val MainScreenGraph = "mainScreenGraph"
}

sealed class MainRouteScreen(val route: String) {
    object Home : MainRouteScreen("Accueil")
    object Contrats : MainRouteScreen("Contrats")
    object Setting : MainRouteScreen("Historique")
    object Profile : MainRouteScreen("Profile")
}

sealed class NewsRouteScreen(val route: String) {
    object NewsDetail : NewsRouteScreen("newsDetail")
}

sealed class SettingRouteScreen(val route: String) {
    object SettingDetail : SettingRouteScreen("settingDetail")
}
