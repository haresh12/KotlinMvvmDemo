package com.example.kotlinmvvmdemo.ui

import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmdemo.data.Quote
import com.example.kotlinmvvmdemo.data.QuoteRepository

class QuoteViewmodel(var quoteRepo: QuoteRepository) :ViewModel() {

    fun addQuote(quote: Quote) {
        quoteRepo.addQuote(quote)
    }

    fun getQuote() = quoteRepo.getQuote()


}
