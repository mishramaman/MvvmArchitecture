package com.example.mvvmarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val dao=QuoteDatabase.getDatabase(applicationContext).getDao()
        val repository=QuoteDatabaseRepository(dao)

        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.getAllQuotes().observe(this, Observer{
            binding.quote=it.toString()
        })



        binding.btnInsertQuote.setOnClickListener {
            val quote=Quote(0,"This is Test Quote","Aman Mishra")
            mainViewModel.insertQuote(quote)

        }
    }
}