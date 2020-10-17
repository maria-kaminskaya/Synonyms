package com.kmnvxh222.synonyms.model.remote

import com.google.gson.JsonArray
import com.google.gson.JsonObject

data class Forms(
    val original: String,
    val lemma: String,
    val pos: String,
    val vector: List<String>,
    val forms: Map<String,List<String>>,
    val forms_query: Map<String,List<String>>,
)


