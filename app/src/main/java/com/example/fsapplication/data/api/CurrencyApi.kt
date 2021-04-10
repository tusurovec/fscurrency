package com.example.fsapplication.data.api

import com.example.fsapplication.data.model.CurrencyResponse
import retrofit2.Call
import retrofit2.http.GET

interface CurrencyApi {

    @GET("/daily_json.js")
    fun getPosts() : Call<CurrencyResponse>
}