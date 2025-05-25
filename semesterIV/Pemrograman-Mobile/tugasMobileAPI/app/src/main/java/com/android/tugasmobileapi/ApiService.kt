package com.android.tugasmobileapi

import com.android.tugasmobileapi.MessageResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("hola")
    fun getMessage(): Call<MessageResponse>

}
