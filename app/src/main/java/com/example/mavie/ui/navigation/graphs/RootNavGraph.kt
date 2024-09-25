package com.example.mavie.ui.navigation

import MainNavScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mavie.ui.auth.LoginScreen


@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Graph.AuthGraph,
        route = Graph.RootGraph
    ) {
        composable(route = Graph.AuthGraph) {
            LoginScreen(
                modifier = Modifier,
                navController = navController,
                context = navController.context
            )
        }
        composable(route = Graph.MainScreenGraph) {
            MainNavScreen(innerPadding = PaddingValues())
        }
    }
}
