package com.stavro_xhardha.home_library.ui.book.todo

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.stavro_xhardha.home_library.model.Book
import com.stavro_xhardha.home_library.repository.BookRepository


class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val bookRepository: BookRepository
    internal var notesList: LiveData<List<Book>>

    init {
        bookRepository = BookRepository(application)
        notesList = bookRepository.getAllNotes()
    }

    fun deleteNote(book: Book) {
        DeleteAsync(bookRepository).execute(book)
    }

    class DeleteAsync(val bookRepository: BookRepository) : AsyncTask<Book, Void, Unit>() {

        override fun doInBackground(vararg params: Book?) {
            params[0]?.let { bookRepository.deleteNote(it) }
        }

    }
}
