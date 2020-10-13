package com.kmnvxh222.synonyms.model.remote

data class Response<T>(
    val msg: String,
    val code: String,
    val response: T?
)
