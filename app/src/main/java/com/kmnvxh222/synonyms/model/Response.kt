package com.kmnvxh222.synonyms.model

import com.google.gson.annotations.SerializedName

data class Response<T>(
    val msg: String,
    val code: String,
    val response: T?
)
