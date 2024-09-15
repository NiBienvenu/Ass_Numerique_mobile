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
import com.example.mavie.ui.navigation.BottomNavigation
import com.example.mavie.ui.navigation.BottomNavigationAnimation
import com.example.mavie.ui.screen.RegisterScreen
import com.example.mavie.ui.screen.LoginScreen
import com.example.mavie.ui.theme.MaVieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configure la fenêtre pour étendre le contenu derrière la barre de navigation système
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MaVieTheme {
                val windowInsets = WindowInsets.navigationBars
                val bottomInset = with(LocalDensity.current) { windowInsets.getBottom(this).toDp() }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationAnimation(
                            listOf(
                                BottomNavigation.Home,
                                BottomNavigation.Create,
                                BottomNavigation.Profile,
                                BottomNavigation.Settings
                            ),
                            //modifier = Modifier.navigationBarsPadding() // Ajoute un padding pour la barre de navigation système
                        )
                    },
//                    contentWindowInsets = WindowInsets(0, 0, 0, 0) // Réinitialise les insets par défaut
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Welcome to the Main Screen",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }

        // Optionnel : cache la barre de navigation système si nécessaire
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.navigationBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
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



