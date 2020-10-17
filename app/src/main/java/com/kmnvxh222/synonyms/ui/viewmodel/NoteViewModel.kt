package com.kmnvxh222.synonyms.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kmnvxh222.synonyms.model.locale.Lexeme
import com.kmnvxh222.synonyms.model.locale.Note
import com.kmnvxh222.synonyms.model.remote.Syn
import com.kmnvxh222.synonyms.repository.locale.LexemesRepositoryImpl
import com.kmnvxh222.synonyms.repository.locale.LexemesRepositoryInterface
import com.kmnvxh222.synonyms.repository.locale.NotesRepositoryImpl
import com.kmnvxh222.synonyms.repository.locale.NotesRepositoryInterface
import com.kmnvxh222.synonyms.repository.remote.RemoteRepositoryImpl
import com.kmnvxh222.synonyms.repository.remote.RemoteRepositoryInterface

class NoteViewModel(context: Context) : ViewModel() {

    private var repository: NotesRepositoryInterface
    private var repositoryL: LexemesRepositoryInterface
    private var repositoryRemote: RemoteRepositoryInterface

    init {
        repository = NotesRepositoryImpl(context)
        repositoryL = LexemesRepositoryImpl(context)
        repositoryRemote = RemoteRepositoryImpl()
    }

    fun addNewNote(note: Note) {
        repository.addNewNote(note)
    }

    fun getNoteById(id: Long) = repository.getNoteById(id)

    fun deleteNote(note: Note) {
        repository.deleteNote(note)
    }

    fun editNote(note: Note) {
        repository.updateNote(note)

    }

    fun getLexeme(lexeme: String)=repositoryL.getLexemeById(lexeme)


    fun addLexeme(word: String){
//        val forms = repositoryRemote.getDataForms(word).value?.forms.toString()
//        val root = repositoryRemote.getDataRoot(word).value?.root.toString()
        val syns = repositoryRemote.getDataSyns(word).value?.syns.toString()
        val lexeme = Lexeme(word,syns)
        repositoryL.addNewLexeme(lexeme)
    }

    fun getLexemeSyns(lexeme: String): MutableLiveData<Syn?> {
        val syns: MutableLiveData<Syn?> = repositoryRemote.getDataSyns(lexeme)
        Log.d("getLexemeSyns", "$syns")
        return syns
    }

}