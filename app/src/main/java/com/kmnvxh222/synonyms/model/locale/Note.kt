package com.kmnvxh222.synonyms.model.locale

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kmnvxh222.synonyms.utils.TypeDateConverter
import java.sql.Date


@Entity(tableName = "notes")
data class Note(
    val title: String,
    val content: String,
    val date: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
