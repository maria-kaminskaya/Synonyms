package com.kmnvxh222.synonyms.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kmnvxh222.synonyms.model.locale.Lexeme
import com.kmnvxh222.synonyms.model.remote.Syn
import com.kmnvxh222.synonyms.repository.locale.LexemesRepositoryImpl
import com.kmnvxh222.synonyms.repository.locale.LexemesRepositoryInterface
import com.kmnvxh222.synonyms.repository.remote.RemoteRepositoryImpl
import com.kmnvxh222.synonyms.repository.remote.RemoteRepositoryInterface

class LexemeViewModel(context: Context) : ViewModel() {

    private var repository: LexemesRepositoryInterface
    private var repositoryRemote: RemoteRepositoryInterface

    init {
        repository = LexemesRepositoryImpl(context)
        repositoryRemote = RemoteRepositoryImpl()
    }

    fun getLexemeById(id: Long) {
        repository.getLexemeById(id)
    }

    fun deleteLexeme(lexeme: Lexeme) {
        repository.deleteLexeme(lexeme)
    }

    fun getLexemeSyns(lexeme: String): MutableLiveData<Syn?> {
        val syns: MutableLiveData<Syn?> = repositoryRemote.getDataSyns(lexeme)
        Log.d("getLexemeSyns", "$syns")
        return syns
    }
}