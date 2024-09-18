package com.example.mavie.ui.auth

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mavie.ui.component.CustomButton

//import coil.compose.rememberImagePainter
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreen(
    modifier: Modifier
) {
    var nom by remember { mutableStateOf("") }
    var prenom by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    var nationalite by remember { mutableStateOf("") }
    var telephone by remember { mutableStateOf("") }
    var motDePasse by remember { mutableStateOf("") }
    var confirmerMotDePasse by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<String?>(null) }

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        uri: Uri? ->
        imageUri = uri.toString()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "S'inscrire",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Image de profil
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
                .clickable { launcher.launch("image/*") },
            contentAlignment = Alignment.Center
        ) {
            if (imageUri != null) {
//                Image(
//                    painter = rememberImagePainter(imageUri),
//                    contentDescription = "Photo de profil",
//                    modifier = Modifier.fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                )
            } else {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Ajouter une photo",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Champs du formulaire
        CustomTextFielld(nom, { nom = it }, "Nom", Icons.Default.Person)
        CustomTextFielld(prenom, { prenom = it }, "Prénom", Icons.Default.Person)
        CustomDropdown(genre, { genre = it }, "Genre", listOf("Homme", "Femme", "Autre"))
        CustomTextFielld(nationalite, { nationalite = it }, "Nationalité", Icons.Default.Place)
        CustomTextFielld(telephone, { telephone = it }, "Téléphone", Icons.Default.Phone, KeyboardType.Phone)
        CustomPasswordField(motDePasse, { motDePasse = it }, "Mot de passe")
        CustomPasswordField(confirmerMotDePasse, { confirmerMotDePasse = it }, "Confirmer le mot de passe")

        Spacer(modifier = Modifier.height(16.dp))

        CustomButton(
            text = "S'inscrire",
            onClick = { /* Logique d'inscription  */ }
        )


    }
}

@Composable
fun CustomTextFielld(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = { Icon(icon, contentDescription = null) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

@Composable
fun CustomPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    if (passwordVisible) Icons.Default.CheckCircle else Icons.Outlined.CheckCircle,
                    contentDescription = if (passwordVisible) "Cacher le mot de passe" else "Afficher le mot de passe"
                )
            }
        },
        visualTransformation = if (passwordVisible) PasswordVisualTransformation() else PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun CustomDropdown(
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    label: String,
    options: List<String>
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = { },
            label = { Text(label) },
            trailingIcon = {
                Icon(
                    if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.ArrowDropDown,
                    contentDescription = "Dérouler"
                )
            },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
//            options.forEach { option ->
//                DropdownMenuItem(
//                    onClick = {
//                        onOptionSelected(option)
//                        expanded = false
//                    },
//                    trailingIcon = Icons(
//                        Icons.Default.CheckCircle,
//                        contentDescription = "Dérouler",
//
//                        ),
//                ) {
//                    Text(text = option)
//                }
            }
        }
    }


