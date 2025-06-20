package com.example.mavie.ui.auth

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mavie.data.SecurePreferencesManager
import com.example.mavie.ui.component.CustomButton
import com.example.mavie.ui.component.CustomTextField
import com.example.mavie.ui.navigation.Graph
import com.example.mavie.ui.theme.primary

@Composable
fun LoginScreen(
    modifier: Modifier,
    navController: NavHostController,
    context: Context
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val securePreferencesManager = SecurePreferencesManager(context)
    LaunchedEffect(Unit) {
        securePreferencesManager.rememberMe.collect { isRemembered ->
            if (isRemembered) {
                navController.navigate(Graph.MainScreenGraph) {
                    popUpTo(Graph.AuthGraph) { inclusive = true }
                }
            }
        }
    }

    val greenColor = Color(0xFF4CAF50)
    val whiteColor = Color.White
    val gradientBackground = Brush.verticalGradient(
        colors = listOf(greenColor, greenColor.copy(alpha = 0.8f), whiteColor),
        startY = 1f,
        endY = 2000f
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBackground)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .width(340.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(16.dp)
                    ),
                shape = RoundedCornerShape(16.dp),
//                backgroundColor = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Icône de connexion",
                        tint = Color(0xFF4CAF50),
                        modifier = Modifier
                            .size(80.dp)
                            .padding(bottom = 16.dp)
                    )

                    Text(
                        text = "Connexion",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 32.dp)
                    )

                    CustomTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = "Nom d'utilisateur",
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Icône utilisateur"
                            )
                        }
                    )

                    CustomTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = "Mot de passe",
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Icône mot de passe"
                            )
                        },
                        isPassword = true
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {

                        Checkbox(
                            checked = rememberMe,
                            onCheckedChange = { rememberMe = it },
                            colors = CheckboxDefaults.colors(checkedColor = primary)
                        )
                        Text("Se souvenir \n de moi",style = MaterialTheme.typography.bodySmall)
                        Spacer(modifier = Modifier.weight(1f))
                        TextButton(
                              onClick = {
                                  println("click")
                                  if (true) {
                                      println("username already present in password field")
                                      // Logique de connexion réussie
                                      if (rememberMe) {
                                          securePreferencesManager.saveRememberMe(true) // Enregistrer l'état "Se souvenir de moi"
                                      }
                                      navController.navigate(Graph.MainScreenGraph) // Naviguer vers l'écran principal
                                  } else {
                                      errorMessage = "Identifiants invalides"
                                  }
                            }
                        ) {
                            Text(
                                "Mot de passe oublié ?",
                                color = primary,
                                style = MaterialTheme.typography.bodySmall
                            )

                        }

                    }
                    CustomButton(
                        text = "Se connecter",
                        onClick = {

                                if (username == "admin" && password == "12345678") {
                                    if (rememberMe) {
                                        securePreferencesManager.saveRememberMe(true)
                                    }

                                    navController.navigate(Graph.MainScreenGraph) {
                                        popUpTo(Graph.AuthGraph) { inclusive = true }
                                    }
                                } else {
                                    errorMessage = "Identifiants invalides"
                                }

                        }
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Avez vous un compte?", style = MaterialTheme.typography.bodySmall,)
                        TextButton(onClick = {  }) {
                            Text(
                                "S'inscrire",
                                color = primary,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }

                }
            }
            Text(text = "Power by DCB", fontSize = 10.sp)
        }
    }

}

