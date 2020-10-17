package com.kmnvxh222.synonyms.model.locale

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lexemes")
data class Lexeme(
    val lexeme: String,
//    val forms: String,
//    val root: String,
    val syns: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}