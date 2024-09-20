package com.example.mavie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mavie.api.KtorClient
import com.example.mavie.ui.navigation.BottomNavigation
import com.example.mavie.ui.navigation.BottomNavigationAnimation
import com.example.mavie.ui.navigation.Graph
import com.example.mavie.ui.navigation.MainRouteScreen
import com.example.mavie.ui.auth.LoginScreen
import com.example.mavie.ui.theme.MaVieTheme
import io.ktor.client.call.body
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import ui.navigation.graphs.RootNavGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaVieTheme {
                val rootNavController = rememberNavController()
                val currentRoute = rootNavController.currentBackStackEntryAsState().value?.destination?.route ?: MainRouteScreen.Home.route


                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationAnimation(
                            screens = listOf(
                                BottomNavigation.Home,
                                BottomNavigation.Contrats,
                                BottomNavigation.Historique,
                                BottomNavigation.Profile
                            ),
                            onItemClick = { route ->
                                rootNavController.navigate(route) {
                                    popUpTo(Graph.MainScreenGraph) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            currentRoute = currentRoute
                        )
                    }
                ) { innerPadding ->
                    RootNavGraph(
                        rootNavController = rootNavController,
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaVieTheme {
//        LoginScreen(
//            modifier = Modifier.padding()
//        )
    }
}



