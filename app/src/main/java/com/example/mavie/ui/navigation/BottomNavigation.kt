package com.example.mavie.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector



sealed class BottomNavigation(
    val title: String,
    val activeIcon: ImageVector,
    val inactiveIcon: ImageVector
) {
    object Home: BottomNavigation("Home", Icons.Filled.Home, Icons.Outlined.Home)
    object Create: BottomNavigation("Create", Icons.Filled.Create, Icons.Outlined.Create)
    object Profile: BottomNavigation("Profile", Icons.Filled.Person, Icons.Outlined.Person)
    object Settings: BottomNavigation("Settings", Icons.Filled.Settings, Icons.Outlined.Settings)
}