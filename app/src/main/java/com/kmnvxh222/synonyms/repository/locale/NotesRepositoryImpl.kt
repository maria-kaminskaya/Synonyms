package com.kmnvxh222.synonyms.repository.locale

import android.content.Context
import android.os.Handler
import androidx.lifecycle.LiveData
import com.kmnvxh222.synonyms.db.getAppDatabase
import com.kmnvxh222.synonyms.model.locale.Note
import com.kmnvxh222.synonyms.repository.async.AsyncRepositoryInterface
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class NotesRepositoryImpl(context: Context) : NotesRepositoryInterface, AsyncRepositoryInterface {

    private val dbDao = getAppDatabase(context).noteDao()!!
    val threadPoolExecutor = ThreadPoolExecutor(1, 5, 0L, TimeUnit.SECONDS, SynchronousQueue())
    override fun addNewNote(note: Note) {
        val task = Runnable {
            dbDao.insertNewNote(note)
        }
        threadPoolExecutor.submit(task)
    }

    override fun updateNote(note: Note) {
        val task = Runnable {
            dbDao.updateNote(note)
        }
        threadPoolExecutor.submit(task)
    }

    override fun deleteNote(note: Note) {
        val task = Runnable {
            dbDao.deleteNote(note)
        }
        threadPoolExecutor.submit(task)
    }

    override fun getAllNotes(): LiveData<List<Note>>? {
        var listNotes: LiveData<List<Note>>? = null
        listNotes = dbDao.getAllLiveData()
        return listNotes
    }

    override fun getNoteById(id: Long): LiveData<Note>? {
        var note: LiveData<Note>? = null
        val task = Runnable {
            note = dbDao.getNoteById(id)
        }
        threadPoolExecutor.submit(task)
        return note
    }

    override fun deleteAll() {
        val task = Runnable {
            dbDao.deleteAllNotes()
        }
        threadPoolExecutor.submit(task)
    }

    override fun close() {
        threadPoolExecutor.shutdown()
    }

}
