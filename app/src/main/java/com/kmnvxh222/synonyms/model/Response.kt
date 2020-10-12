package com.kmnvxh222.synonyms.model

data class Response<T> (
    val msg : String,
    val code : Int,
    val response: T?
)