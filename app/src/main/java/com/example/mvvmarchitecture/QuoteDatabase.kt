package com.example.mvvmarchitecture

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract  class QuoteDatabase:RoomDatabase(){

    abstract fun getDao():QuoteDao

    companion object{
        private var Instance:QuoteDatabase?=null

        fun getDatabase(context:Context):QuoteDatabase{
            if (Instance==null){
                synchronized(this){
                    Instance=Room.databaseBuilder(
                        context.applicationContext,
                    QuoteDatabase::class.java,
                    "quotes_dataBase").createFromAsset("quotes.db").build()
                }
            }
            return  Instance!!
        }
    }
}