package ui.navigation.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder

import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.mavie.ui.navigation.Graph
import com.example.mavie.ui.navigation.MainRouteScreen
import com.example.mavie.ui.navigation.navigationScreen.CreateScreen
import com.example.mavie.ui.navigation.navigationScreen.EditScreen
import com.example.mavie.ui.navigation.navigationScreen.HomeScreen
import com.example.mavie.ui.navigation.navigationScreen.SettingScreen

fun NavGraphBuilder.mainNavGraph(
    rootNavController: NavHostController,
    innerPadding: PaddingValues
) {
    navigation(
        startDestination = MainRouteScreen.Home.route,
        route = Graph.MainScreenGraph
    ) {
        composable(route = MainRouteScreen.Home.route) {
            HomeScreen(rootNavController = rootNavController, paddingValues = innerPadding)
        }
        composable(route = MainRouteScreen.Contrats.route) {
            EditScreen(rootNavController = rootNavController, paddingValues = innerPadding)
        }
        composable(route = MainRouteScreen.Setting.route) {
            SettingScreen(rootNavController = rootNavController, paddingValues = innerPadding)
        }
        composable(route = MainRouteScreen.Profile.route) {
            CreateScreen(rootNavController = rootNavController, paddingValues = innerPadding)
        }
    }
}