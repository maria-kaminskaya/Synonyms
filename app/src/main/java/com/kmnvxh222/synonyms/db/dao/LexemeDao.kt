package com.kmnvxh222.synonyms.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kmnvxh222.synonyms.model.locale.Lexeme

@Dao
interface LexemeDao {
    @Insert
    fun insertNewLexeme(lexeme: Lexeme)

    @Delete
    fun deleteLexeme(lexeme: Lexeme)

    @Query("SELECT * FROM lexemes")
    fun getAllLiveData(): LiveData<List<Lexeme>>?

    @Query("SELECT * FROM lexemes WHERE lexeme = :content")
    fun getLexemeById(content: String): LiveData<Lexeme>?

    @Query("DELETE FROM lexemes")
    fun deleteAllLexemes()
}