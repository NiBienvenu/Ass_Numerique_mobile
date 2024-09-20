package com.example.mavie.modelView.auth


import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var isAuthenticated = false
        private set

    fun login(username: String, password: String, onSuccess: () -> Unit, onError: () -> Unit) {

    }
}