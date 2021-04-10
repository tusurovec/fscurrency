package com.example.fsapplication.presentation.state

import com.example.fsapplication.domain.entity.Currency

sealed class CurrenciesState {

    data class Content(val currencyList: List<Currency>) : CurrenciesState()

    object Loading : CurrenciesState()

    object Error : CurrenciesState()
}