package com.example.quotemvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Dao {
    private val quoteList = mutableListOf<Quote>()

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)

        quotes.value = quoteList

    }
    fun getQuote(): LiveData<List<Quote>> = quotes

}