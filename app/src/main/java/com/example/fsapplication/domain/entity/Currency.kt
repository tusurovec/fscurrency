package com.example.fsapplication.domain.entity

data class Currency(
    val name:String,
    val value: Double,
    val previous: Double,
    val charCode: String
)