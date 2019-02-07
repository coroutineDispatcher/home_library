package com.stavro_xhardha.todo.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.stavro_xhardha.todo.database.NotesDatabase
import com.stavro_xhardha.todo.model.Note
import com.stavro_xhardha.todo.model.NoteDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NotesRepository(application: Application) {
    private val notesDao: NoteDao
    private val notesList: LiveData<List<Note>>

    init {
        val notesDatabase = NotesDatabase.getInstance(application)
        notesDao = notesDatabase?.notesDao()!!
        notesList = notesDao.getAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return notesList
    }

    fun insert(note: Note) {
        Observable.just(notesDao.insertNewNote(note))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe()
    }

    fun deleteNote(note: Note) {
        notesDao.delete(note)
    }
}