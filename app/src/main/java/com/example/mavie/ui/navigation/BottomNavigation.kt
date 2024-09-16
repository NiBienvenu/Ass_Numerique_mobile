package com.example.mavie.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector



sealed class BottomNavigation(
    val title: String,
    val activeIcon: ImageVector,
    val inactiveIcon: ImageVector
) {
    object Home: BottomNavigation("Accueil", Icons.Filled.Home, Icons.Outlined.Home)
    object Contrats: BottomNavigation("Contrats", Icons.Filled.DateRange, Icons.Outlined.DateRange)
    object Historique: BottomNavigation("Historique", Icons.Filled.Settings, Icons.Outlined.Settings)
    object Profile: BottomNavigation("Profile", Icons.Filled.Person, Icons.Outlined.Person)
}