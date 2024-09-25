package com.example.mavie.ui.navigation

object Graph {
    const val MainScreenGraph = "mainScreenGraph"
    const val RootGraph = "root_graph"
    const val AuthGraph = "auth_graph"
}

sealed class MainRouteScreen(val route: String) {
    object Home : MainRouteScreen("Accueil")
    object Contrats : MainRouteScreen("Contrats")
    object Setting : MainRouteScreen("Historique")
    object Profile : MainRouteScreen("Profile")
}

sealed class AuhtRouteScreen(val route: String) {
    object Login : AuhtRouteScreen("login")
    object register : AuhtRouteScreen("register")
    object ForgetPassword : AuhtRouteScreen("forgetPassword")

}

sealed class SettingRouteScreen(val route: String) {
    object SettingDetail : SettingRouteScreen("settingDetail")
}
