package com.kmnvxh222.synonyms.model.locale

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kmnvxh222.synonyms.utils.TypeDateConverter
import java.io.Serializable
import java.sql.Date


@Entity(tableName = "notes")
data class Note(
    var title: String,
    var content: String,
    var date: String
):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
