package com.example.quotemvvm.quote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.quotemvvm.R
import com.example.quotemvvm.data.Quote
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: QuotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(QuotesViewModel::class.java)
        initialize()
    }

    fun initialize() {
        observe()
        btnAdd.setOnClickListener {
            val quote = Quote(etQuote.text.toString(), etAuthor.text.toString())
            viewModel.addQuote(quote)
            etQuote.setText("")
            etAuthor.setText("")
        }
    }

    private fun observe(){
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n")
            }
            tvQuote.text = stringBuilder.toString()
        })
    }
}

