package com.kmnvxh222.synonyms.utils

import androidx.room.TypeConverter
import java.sql.Date

class TypeDateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}