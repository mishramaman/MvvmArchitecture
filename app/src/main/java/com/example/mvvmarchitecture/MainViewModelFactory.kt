package com.example.mvvmarchitecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private var quoteDatabaseRepository: QuoteDatabaseRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quoteDatabaseRepository) as T
    }
}