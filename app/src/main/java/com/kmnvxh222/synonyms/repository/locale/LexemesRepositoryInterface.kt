package com.kmnvxh222.synonyms.repository.locale

import androidx.lifecycle.LiveData
import com.kmnvxh222.synonyms.model.locale.Lexeme

interface LexemesRepositoryInterface {
    fun addNewLexeme(lexeme: Lexeme)
    fun deleteLexeme(lexeme: Lexeme)
    fun getAllLexemes(): LiveData<List<Lexeme>>?
    fun getLexemeById(id: Long): Lexeme?
    fun deleteAll()
}