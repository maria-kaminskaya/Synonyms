package com.kmnvxh222.synonyms.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kmnvxh222.synonyms.repository.locale.NotesRepositoryImpl
import com.kmnvxh222.synonyms.repository.locale.NotesRepositoryInterface

class AllNotesViewModel(context: Context): ViewModel() {

    private var repository: NotesRepositoryInterface

    init {
        repository = NotesRepositoryImpl(context)
    }


    fun getAllNotes()=
        repository.getAllNotes()


    fun deleteAllNote(){
        repository.deleteAll()
    }
}