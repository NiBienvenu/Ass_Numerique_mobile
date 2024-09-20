package com.example.mavie.modelView.auth

import android.net.http.HttpResponseCache.install
import androidx.lifecycle.ViewModel
import io.ktor.client.HttpClient
import kotlinx.serialization.Serializable

class AuthViewModel : ViewModel() {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    var isAuthenticated = false
        private set

    fun login(username: String, password: String, onSuccess: () -> Unit, onError: () -> Unit) {
        viewModelScope.launch {
            try {
                val response: AuthResponse = client.post("https://yourapi.com/login") {
                    contentType(ContentType.Application.Json)
                    body = AuthRequest(username, password)
                }
                // Store token or user data here
                isAuthenticated = true
                onSuccess()
            } catch (e: Exception) {
                onError()
            }
        }
    }
}