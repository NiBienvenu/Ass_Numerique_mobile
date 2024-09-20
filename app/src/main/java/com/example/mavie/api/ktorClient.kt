package com.example.mavie.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import kotlinx.serialization.json.Json
import io.ktor.serialization.kotlinx.json.json


class KtorClient{
    private val client = HttpClient(OkHttp){
        defaultRequest { url("https://jsonplaceholder.typicode.com/") }

        install(Logging){
            logger = Logger.SIMPLE
        }


        install(ContentNegotiation) {
            json(
                Json{
                    ignoreUnknownKeys = true
                },

            )
        }
    }
}
