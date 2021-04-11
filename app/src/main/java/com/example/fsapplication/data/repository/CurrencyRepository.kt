package com.example.fsapplication.data.repository

import com.example.fsapplication.data.api.CurrencyApi
import com.example.fsapplication.data.converter.CurrencyConverter
import com.example.fsapplication.data.model.CurrencyResponse
import com.example.fsapplication.domain.entity.Currency
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrencyRepository {

    companion object {
        const val BASE_URL = "https://www.cbr-xml-daily.ru"
    }

    private var currencyList: List<Currency> = emptyList()

    fun getCurrencies(
        onSuccess: (List<Currency>) -> Unit,
        onError: () -> Unit
    ) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(CurrencyApi::class.java)
        val call = api.getPosts()

        call.enqueue(object : Callback<CurrencyResponse> {
            override fun onFailure(call: Call<CurrencyResponse>, t: Throwable) {
                onError()
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<CurrencyResponse>,
                response: Response<CurrencyResponse>
            ) {
                val currencyResponse = response.body() as CurrencyResponse
                val currencies = CurrencyConverter().convert(currencyResponse)

                currencyList = currencies

                onSuccess.invoke(currencies)
            }
        })
    }
}