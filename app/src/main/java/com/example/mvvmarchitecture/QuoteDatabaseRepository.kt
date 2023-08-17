package com.example.mvvmarchitecture

import androidx.lifecycle.LiveData

class QuoteDatabaseRepository(private var quoteDao: QuoteDao) {

    fun getAllQuotes():LiveData<List<Quote>>{
        return quoteDao.getAllQuotes()
    }

    suspend fun insertQuote(quote: Quote){
        quoteDao.insertQuote(quote)
    }
}