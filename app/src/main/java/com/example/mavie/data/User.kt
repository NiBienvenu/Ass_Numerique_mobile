package com.example.mavie.data

import kotlinx.serialization.Serializable


@Serializable
data class User(
    val id: Int,
    val nom: String,
    val prenom: String,
    val username: String,
    val motDePasse: String,
    val email: String,
    val telephone: String,
    val pays: Int, // FK vers nationalité
    val province: Int, // FK vers province
    val commune: Int, // FK vers commune
    val zone: Int, // FK vers zone
    val colline: Int, // FK vers colline
    val residence_actuelle: String? = null, // Nullable
    val status: Boolean,
    val genre: String,
    val adresse: String,
    val date_naissance: String, // Peut être changé en LocalDate si nécessaire
    val cni: String,
    val profil: String
)