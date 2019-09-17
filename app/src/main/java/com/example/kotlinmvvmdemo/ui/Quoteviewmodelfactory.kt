package com.example.kotlinmvvmdemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmvvmdemo.data.QuoteRepository

class Quoteviewmodelfactory(private val quoteRepo: QuoteRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <viewModel : ViewModel?> create(modelClass: Class<viewModel>): viewModel {
        @Suppress("UNCHECKED_CAST")
        return QuoteViewmodel(quoteRepo) as viewModel
    }
}
