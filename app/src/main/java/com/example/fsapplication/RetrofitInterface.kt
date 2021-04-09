package com.example.fsapplication

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @get:GET("daily_json.js")
    val posts : Call<List<PostModel?>?>?

    companion object {
        const val BASE_URL = "https://www.cbr-xml-daily.ru/"
    }
}