package com.kmnvxh222.synonyms.model.remote

import com.google.gson.JsonObject

data class Root(
    val original: String,
    val lemma: String,
    val pos: String,
    val root: JsonObject
)
