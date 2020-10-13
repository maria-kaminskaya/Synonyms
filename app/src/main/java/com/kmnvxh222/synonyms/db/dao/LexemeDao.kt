package com.kmnvxh222.synonyms.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kmnvxh222.synonyms.model.locale.Lexeme
import com.kmnvxh222.synonyms.model.locale.Note

@Dao
interface LexemeDao {
    @Insert
    fun insertNewLexeme(lexeme: Lexeme)

    @Delete
    fun deleteLexeme(lexeme: Lexeme)

    @Query("SELECT * FROM lexemes")
    fun getAllLiveData(): LiveData<List<Lexeme>>

    @Query("SELECT * FROM lexemes WHERE id = :id")
    fun getLexemeById(id: Long): Lexeme
}