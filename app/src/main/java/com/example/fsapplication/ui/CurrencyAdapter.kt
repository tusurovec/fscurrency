package com.example.fsapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fsapplication.R
import com.example.fsapplication.domain.entity.Currency
import kotlinx.android.synthetic.main.currency_item.view.*

class CurrencyAdapter(private val currencies: List<Currency>) :
    RecyclerView.Adapter<CurrencyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.currency_item, parent, false)
        return CurrencyViewHolder(view)
    }

    override fun getItemCount(): Int = currencies.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(currencies[position])
    }
}

class CurrencyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: Currency) {
        itemView.currencyName.text = item.name
        itemView.currencyCharCode.text = item.charCode
        itemView.currentValue.text = item.value.toString()
        itemView.previousValue.text = item.value.toString()
    }
}