package com.example.mvvmarchitecture

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao{

    @Query("Select * from quote")
    fun getAllQuotes():LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)



}