package com.kmnvxh222.synonyms.repository.locale

import androidx.lifecycle.LiveData
import com.kmnvxh222.synonyms.model.locale.Note

interface NotesRepositoryInterface {
    fun addNewNote(note: Note)
    fun updateNote(note: Note)
    fun deleteNote(note: Note)
    fun getAllNotes(): LiveData<List<Note>>?
    fun getNoteById(id: Long): LiveData<Note>?
    fun deleteAll()
}