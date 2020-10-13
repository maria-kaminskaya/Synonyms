package com.kmnvxh222.synonyms.model.remote

data class Syn(
    val original : String,
    val lemma : String,
    val pos : String,
    val syns : List<String>
)