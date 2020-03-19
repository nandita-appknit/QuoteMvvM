package com.example.quotemvvm.quote

import androidx.lifecycle.ViewModel
import com.example.quotemvvm.data.Dao
import com.example.quotemvvm.data.Quote

class QuotesViewModel() : ViewModel() {
    private val quotedao: Dao=Dao()

    fun getQuotes() = quotedao.getQuote()

    fun addQuote(quote: Quote) = quotedao.addQuote(quote)
}