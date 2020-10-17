package com.kmnvxh222.synonyms.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kmnvxh222.synonyms.model.locale.Note

@Dao
interface NoteDao {
    @Insert
    fun insertNewNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("SELECT * FROM notes")
    fun getAllLiveData(): LiveData<List<Note>>?

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNoteById(id: Long): LiveData<Note>?

    @Query("DELETE FROM notes")
    fun deleteAllNotes()
}