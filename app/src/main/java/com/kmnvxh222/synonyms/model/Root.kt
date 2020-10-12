package com.kmnvxh222.synonyms.model


data class Root(
    val original: String,
    val lemma: String,
    val pos: String,
    val root: List<String>
)
