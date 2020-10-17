package com.kmnvxh222.synonyms.utils

import androidx.room.TypeConverter
import java.util.stream.Collectors

class TypeListConverter {
    @TypeConverter
    fun fromList(hobbies: List<String?>): String {
        return hobbies.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toList(data: String): List<Array<String>> {
        return listOf(data.split(",".toRegex()).toTypedArray())
    }
}