package com.example.mavie.data

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SecurePreferencesManager(context: Context) {

    private val masterKeyAlias = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "secure_prefs",
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    private val _rememberMe = MutableStateFlow(sharedPreferences.getBoolean("remember_me", false))
    val rememberMe: Flow<Boolean> get() = _rememberMe.asStateFlow()

    fun saveRememberMe(value: Boolean) {
        sharedPreferences.edit().putBoolean("remember_me", value).apply()
        _rememberMe.value = value
    }
}