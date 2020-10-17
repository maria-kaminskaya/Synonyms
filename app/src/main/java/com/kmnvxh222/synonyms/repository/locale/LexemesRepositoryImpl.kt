package com.kmnvxh222.synonyms.repository.locale

import android.content.Context
import android.os.Handler
import androidx.lifecycle.LiveData
import com.kmnvxh222.synonyms.db.getAppDatabase
import com.kmnvxh222.synonyms.model.locale.Lexeme
import com.kmnvxh222.synonyms.repository.async.AsyncRepositoryInterface
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class LexemesRepositoryImpl(context: Context) : LexemesRepositoryInterface,
    AsyncRepositoryInterface {

    private val dbDao = getAppDatabase(context).lexemeDao()!!
    private val threadPoolExecutor = ThreadPoolExecutor(1, 5, 0L, TimeUnit.SECONDS, SynchronousQueue())
    private val handler = Handler()
    override fun addNewLexeme(lexeme: Lexeme) {
        val task = Runnable {
            dbDao.insertNewLexeme(lexeme)
        }
        threadPoolExecutor.submit(task)
    }

    override fun deleteLexeme(lexeme: Lexeme) {
        val task = Runnable {
            dbDao.deleteLexeme(lexeme)
        }
        threadPoolExecutor.submit(task)
    }

    override fun getAllLexemes(): LiveData<List<Lexeme>>? {
        var listLexemes: LiveData<List<Lexeme>>? = null
            listLexemes = dbDao.getAllLiveData()
        return listLexemes
    }

    override fun getLexemeById(id: Long): Lexeme? {
        var lexeme: Lexeme? = null
        val task = Runnable {
            lexeme = dbDao.getLexemeById(id)
        }
        threadPoolExecutor.submit(task)
        return lexeme
    }

    override fun deleteAll() {
        val task = Runnable {
            dbDao.deleteAllLexemes()
        }
        threadPoolExecutor.submit(task)
    }

    override fun close() {
        threadPoolExecutor.shutdown()
    }
}