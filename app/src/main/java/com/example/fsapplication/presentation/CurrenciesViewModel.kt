package com.example.fsapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fsapplication.App
import com.example.fsapplication.presentation.state.CurrenciesState

class CurrenciesViewModel : ViewModel() {

    private val repository = App.getInstance().repository

    private val _state = MutableLiveData<CurrenciesState>()
    val state: LiveData<CurrenciesState> = _state

    fun loadCurrencies() {
        repository?.getCurrencies(
            onSuccess = { _state.value = CurrenciesState.Content(it) },
            onError = { proceedError() }
        )
        _state.value = CurrenciesState.Loading
    }

    private fun proceedError() {
        _state.value = CurrenciesState.Error
    }
}