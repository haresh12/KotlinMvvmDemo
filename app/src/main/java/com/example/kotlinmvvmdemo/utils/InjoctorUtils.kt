package com.example.kotlinmvvmdemo.utils

import com.example.kotlinmvvmdemo.data.FakeDataBase
import com.example.kotlinmvvmdemo.data.FakeQouteDao
import com.example.kotlinmvvmdemo.data.QuoteRepository
import com.example.kotlinmvvmdemo.ui.Quoteviewmodelfactory

object InjoctorUtils {
    fun provideQuoteViewModelFactory(): Quoteviewmodelfactory {
        val repository = QuoteRepository.getInstance(FakeDataBase.getInstance().quoteDao)
        return Quoteviewmodelfactory(repository)
    }

}
