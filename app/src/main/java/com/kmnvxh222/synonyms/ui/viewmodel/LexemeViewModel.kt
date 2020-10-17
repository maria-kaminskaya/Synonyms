package com.kmnvxh222.synonyms.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kmnvxh222.synonyms.model.locale.Lexeme
import com.kmnvxh222.synonyms.repository.locale.LexemesRepositoryImpl
import com.kmnvxh222.synonyms.repository.locale.LexemesRepositoryInterface
import com.kmnvxh222.synonyms.repository.locale.NotesRepositoryImpl

class LexemeViewModel(context: Context) : ViewModel() {

    private var repository: LexemesRepositoryInterface

    init {
        repository = LexemesRepositoryImpl(context)
    }

    fun getLexemeById(id: Long){
        repository.getLexemeById(id)
    }

    fun deleteLexeme(lexeme: Lexeme){
        repository.deleteLexeme(lexeme)
    }
}