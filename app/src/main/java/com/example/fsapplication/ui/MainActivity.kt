package com.example.fsapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fsapplication.R
import com.example.fsapplication.domain.entity.Currency
import com.example.fsapplication.presentation.CurrenciesViewModel
import com.example.fsapplication.presentation.state.CurrenciesState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CurrenciesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(CurrenciesViewModel::class.java)

        viewModel.state.observe(this, Observer { applyState(it) })

        viewModel.loadCurrencies()

        swipeRefresh.setOnRefreshListener {
            viewModel.loadCurrencies()
        }
    }

    private fun applyState(state: CurrenciesState) {
        when (state) {
            CurrenciesState.Loading -> applyLoadingState()
            is CurrenciesState.Content -> applyContentState(state.currencyList)
            CurrenciesState.Error -> applyErrorState()
        }
    }

    private fun applyLoadingState() {
        swipeRefresh.isRefreshing = false
        swipeRefresh.isVisible = false
        progress.isVisible = true
    }

    private fun applyContentState(currencies: List<Currency>) {
        swipeRefresh.isRefreshing = false
        swipeRefresh.isVisible = true
        progress.isVisible = false

        currenciesList.adapter = CurrencyAdapter(currencies)
    }

    private fun applyErrorState() {
        swipeRefresh.isRefreshing = false
        swipeRefresh.isVisible = false
        progress.isVisible = false

        Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
    }
}