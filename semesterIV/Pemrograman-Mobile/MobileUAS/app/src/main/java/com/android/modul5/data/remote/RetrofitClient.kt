package com.android.modul5.data.remote

import com.android.modul5.data.remote.api.TMDBAPI
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object RetrofitClient {
    private val json = Json {
        ignoreUnknownKeys = true
    }
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    const  val APIKEY = "9d2494a8a2a5c08592c8e963a74c799a"

    val tmdbAPI: TMDBAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(TMDBAPI::class.java)
    }
}