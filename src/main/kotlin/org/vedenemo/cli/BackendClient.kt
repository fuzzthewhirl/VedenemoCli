package org.vedenemo.cli

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object BackendClient {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun echo(message: String): String {
        println("message: $message")
        val response: HttpResponse = client.post("http://localhost:8080/model/echo") {
            setBody(message)
        }
        val body = response.body<String>()
        println("\nresponse.body: $body\n")
        val status = response.status
        println("\nresponse.status: $status\n")
        return body
    }
}