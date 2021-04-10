package com.example.fsapplication

import android.app.Application
import com.example.fsapplication.data.repository.CurrencyRepository

class App : Application() {

    companion object {

        private lateinit var instance: App

        fun getInstance(): App = instance
    }

    var repository: CurrencyRepository? = null

    override fun onCreate() {
        super.onCreate()

        instance = this

        repository = CurrencyRepository()
    }
}