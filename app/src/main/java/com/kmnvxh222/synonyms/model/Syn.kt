package com.kmnvxh222.synonyms.model

data class Syn(
    val original : String,
    val lemma : String,
    val pos : String,
    val syns : List<String>
)