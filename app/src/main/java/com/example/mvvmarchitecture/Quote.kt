package com.example.mvvmarchitecture

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.text.Typography.quote


@Entity(tableName = "Quote")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val text:String,
    val author:String
)
