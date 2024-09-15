package com.example.mavie.ui.navigation.navigationScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun CreateScreen(rootNavController: NavHostController, paddingValues: PaddingValues) {
    // Contenu de l'écran de création
    Column(modifier = Modifier.padding(paddingValues)) {
        Text(text = "Create Screen", style = MaterialTheme.typography.bodyLarge)
        // Ajoutez ici d'autres composants UI
    }
}