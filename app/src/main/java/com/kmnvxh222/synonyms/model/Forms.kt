package com.kmnvxh222.synonyms.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Forms(

    val original : String,
    val lemma : String,
    val pos : String,
    val vector : List<String>,
    val forms : List<String>,
    val forms_query : List<String>
)


data class r(
    @JsonProperty("1")
    val one: String
)
