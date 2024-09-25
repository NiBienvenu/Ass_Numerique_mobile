package com.example.mavie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mavie.ui.navigation.BottomNavigation
import com.example.mavie.ui.navigation.BottomNavigationAnimation
import com.example.mavie.ui.navigation.Graph
import com.example.mavie.ui.navigation.MainRouteScreen
import com.example.mavie.ui.navigation.RootNavGraph
import com.example.mavie.ui.theme.MaVieTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaVieTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    RootNavGraph(navController = navController)
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



