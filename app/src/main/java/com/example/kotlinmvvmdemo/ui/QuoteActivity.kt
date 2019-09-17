package com.example.kotlinmvvmdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinmvvmdemo.R
import com.example.kotlinmvvmdemo.data.Quote
import com.example.kotlinmvvmdemo.utils.InjoctorUtils
import kotlinx.android.synthetic.main.activity_qoute.*
import java.lang.StringBuilder

class QuoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qoute)
        initializeUi()
    }


    private fun initializeUi() {
        val factory = InjoctorUtils.provideQuoteViewModelFactory()
        val provider = ViewModelProviders.of(this as FragmentActivity, factory).get(QuoteViewmodel::class.java)
        provider.getQuote().observe(this, Observer { qoute ->
            val builder = StringBuilder()
            qoute.forEach { qoute ->
                builder.append("$qoute\n\n")
            }
            textView_quotes.text = builder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            provider.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }

}
