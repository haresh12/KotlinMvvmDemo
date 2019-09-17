package com.example.kotlinmvvmdemo.data


class QuoteRepository private constructor(var quotes: FakeQouteDao) {


    fun addQuote(quote: Quote) {
        quotes.addQoutes(quote)
    }

    fun getQuote() = quotes.getQoutes()


    companion object {
        @Volatile
        private var instance: QuoteRepository? = null

        fun getInstance(quote: FakeQouteDao) =
            instance ?: synchronized(this)
            {
                instance ?: QuoteRepository(quote).also { instance = it }
            }
    }
}