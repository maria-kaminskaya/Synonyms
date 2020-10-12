package com.kmnvxh222.synonyms.model

import com.google.gson.JsonArray
import com.google.gson.JsonObject

data class Forms(
    val original: String,
    val lemma: String,
    val pos: String,
    val vector: List<String>,
    val forms: JsonArray,
    val forms_query: JsonObject
)


