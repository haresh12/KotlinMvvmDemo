package com.example.kotlinmvvmdemo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQouteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun addQoutes(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQoutes() = quotes as LiveData<List<Quote>>

}
