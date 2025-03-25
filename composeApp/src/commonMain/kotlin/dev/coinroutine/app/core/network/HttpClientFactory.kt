//package dev.coinroutine.app.core.network
//
//import io.ktor.client.HttpClient
//import io.ktor.client.engine.HttpClientEngine
//import io.ktor.client.plugins.HttpTimeout
//import io.ktor.client.plugins.cache.HttpCache
//import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
//import io.ktor.client.plugins.defaultRequest
//import io.ktor.client.request.headers
//import io.ktor.http.ContentType
//import io.ktor.http.contentType
//import io.ktor.serialization.kotlinx.json.json
//import kotlinx.serialization.json.Json
////import dev.coinroutine.BuildConfig
//
//
//
//object HttpClientFactory {
//
////    val apiKey = BuildConfig.API_KEY
//
//    fun create(engine: HttpClientEngine): HttpClient {
//        return HttpClient(engine) {
//            install(ContentNegotiation) {
//                json(
//                    json = Json {
//                        ignoreUnknownKeys = true
//                    }
//                )
//            }
//            install(HttpTimeout) {
//                socketTimeoutMillis = 20_000L
//                requestTimeoutMillis = 20_000L
//            }
//            install(HttpCache)
//            defaultRequest {
//                headers { append("x-access-token", "coinranking8293298cf58e958b4e251686197c1d9b2650872554bcb87d") }
//                contentType(ContentType.Application.Json)
//            }
//        }
//    }
//}

package dev.coinroutine.app.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientFactory {
    fun create(engine: HttpClientEngine, apiKey: String): HttpClient {
        return HttpClient(engine) {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(HttpTimeout) {
                socketTimeoutMillis = 20_000L
                requestTimeoutMillis = 20_000L
            }
            install(HttpCache)
            defaultRequest {
                headers { append("x-access-token", apiKey) } // Pass API key dynamically
                contentType(ContentType.Application.Json)
            }
        }
    }
}
