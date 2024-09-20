package com.example.mavie.api

import com.example.mavie.data.Todo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
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

    suspend fun getTodo(): Any? {
        return client.get("/todos").bodyAsText()
    }
}
