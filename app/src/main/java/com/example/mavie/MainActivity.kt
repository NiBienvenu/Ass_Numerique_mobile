package com.example.mavie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mavie.ui.navigation.BottomNavigation
import com.example.mavie.ui.navigation.BottomNavigationAnimation
import com.example.mavie.ui.navigation.Graph
import com.example.mavie.ui.navigation.MainRouteScreen
import com.example.mavie.ui.screen.RegisterScreen
import com.example.mavie.ui.screen.LoginScreen
import com.example.mavie.ui.theme.MaVieTheme
import ui.navigation.graphs.RootNavGraph
import ui.navigation.graphs.mainNavGraph


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
        LoginScreen(
            modifier = Modifier.padding()
        )
    }
}



