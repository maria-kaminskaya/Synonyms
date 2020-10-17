package com.kmnvxh222.synonyms.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kmnvxh222.synonyms.repository.locale.LexemesRepositoryImpl
import com.kmnvxh222.synonyms.repository.locale.LexemesRepositoryInterface

class FavoritesViewModel(context: Context): ViewModel()  {
    private var repository: LexemesRepositoryInterface

    init {
        repository = LexemesRepositoryImpl(context)
    }

    fun getAllLexemes(){
        repository.getAllLexemes()
    }

    fun deleteAll(){
        repository.deleteAll()
    }
}
