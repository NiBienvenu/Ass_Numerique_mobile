import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mavie.ui.navigation.BottomNavigation
import com.example.mavie.ui.navigation.BottomNavigationAnimation
import com.example.mavie.ui.navigation.Graph
import com.example.mavie.ui.navigation.MainRouteScreen
import com.example.mavie.ui.navigation.navigationScreen.CreateScreen
import com.example.mavie.ui.navigation.navigationScreen.EditScreen
import com.example.mavie.ui.navigation.navigationScreen.HomeScreen
import com.example.mavie.ui.navigation.navigationScreen.SettingScreen
@Composable
fun MainNavScreen(
    innerPadding: PaddingValues
) {
    val navControl = rememberNavController()
    val currentRoute = navControl.currentBackStackEntryAsState().value?.destination?.route
        ?: MainRouteScreen.Home.route

    Scaffold(
        bottomBar = {
            BottomNavigationAnimation(
                screens = listOf(
                    BottomNavigation.Home,
                    BottomNavigation.Contrats,
                    BottomNavigation.Historique,
                    BottomNavigation.Profile
                ),
                onItemClick = { route ->
                    navControl.navigate(route) {
                        popUpTo(Graph.MainScreenGraph) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                currentRoute = currentRoute
            )
        }
    ) { paddingValues ->
        // Assurez-vous que rootNavController est correctement initialisé ici

        NavHost(
            navController = navControl,
            startDestination = MainRouteScreen.Home.route,
            route = Graph.MainScreenGraph
        ) {
            mainNavGraph(navControl, paddingValues)
        }
    }
}

fun NavGraphBuilder.mainNavGraph(
    rootNavController: NavHostController,
    paddingValues: PaddingValues
) {
    composable(route = MainRouteScreen.Home.route) {
        HomeScreen(rootNavController = rootNavController, paddingValues = paddingValues)
    }
    composable(route = MainRouteScreen.Contrats.route) {
        EditScreen(rootNavController = rootNavController, paddingValues = paddingValues)
    }
    composable(route = MainRouteScreen.Setting.route) {
        SettingScreen(rootNavController = rootNavController, paddingValues = paddingValues)
    }
    composable(route = MainRouteScreen.Profile.route) {
        CreateScreen(rootNavController = rootNavController, paddingValues = paddingValues)
    }
}
