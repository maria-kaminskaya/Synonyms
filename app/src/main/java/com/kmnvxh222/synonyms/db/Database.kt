package com.kmnvxh222.synonyms.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kmnvxh222.synonyms.db.dao.LexemeDao
import com.kmnvxh222.synonyms.db.dao.NoteDao
import com.kmnvxh222.synonyms.model.locale.Lexeme
import com.kmnvxh222.synonyms.model.locale.Note

@Database(entities = [Note::class,Lexeme::class ], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao?
    abstract fun lexemeDao(): LexemeDao?
}

fun getAppDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "database")
        .allowMainThreadQueries()
        .build()
}


