package com.example.fsapplication.data.converter

import com.example.fsapplication.data.model.CurrencyResponse
import com.example.fsapplication.domain.entity.Currency

class CurrencyConverter {

    fun convert(from: CurrencyResponse): List<Currency> =
        from.valute.values.map { currencyModel ->
            Currency(
                name = currencyModel.name,
                value = currencyModel.value,
                previous = currencyModel.previous,
                charCode = currencyModel.charCode
            )
        }
}