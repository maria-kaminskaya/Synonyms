package com.kmnvxh222.synonyms.model

import com.google.gson.annotations.SerializedName

data class GetOne<T>(
    @SerializedName("1")
    val one: T? = null
)