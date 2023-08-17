package com.example.mvvmarchitecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private var quoteDatabaseRepository: QuoteDatabaseRepository): ViewModel() {

    fun getAllQuotes():LiveData<List<Quote>>{
        return  quoteDatabaseRepository.getAllQuotes()
    }

    fun insertQuote(quote: Quote){
        viewModelScope.launch(Dispatchers.IO) {
            quoteDatabaseRepository.insertQuote(quote)

        }
    }
}