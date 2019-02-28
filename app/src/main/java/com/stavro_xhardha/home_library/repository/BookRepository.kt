package com.stavro_xhardha.home_library.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.stavro_xhardha.home_library.database.BookDatabase
import com.stavro_xhardha.home_library.model.Book
import com.stavro_xhardha.home_library.model.BookDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BookRepository(application: Application) {
    private val notesDao: BookDao
    private val notesList: LiveData<List<Book>>

    init {
        val notesDatabase = BookDatabase.getInstance(application)
        notesDao = notesDatabase?.notesDao()!!
        notesList = notesDao.getAllNotes()
    }

    fun getAllNotes(): LiveData<List<Book>> {
        return notesList
    }

    fun insert(book: Book) {
        Observable.just(notesDao.insertNewNote(book))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.computation())
            .subscribe()
    }

    fun deleteNote(book: Book) {
        notesDao.delete(book)
    }
}