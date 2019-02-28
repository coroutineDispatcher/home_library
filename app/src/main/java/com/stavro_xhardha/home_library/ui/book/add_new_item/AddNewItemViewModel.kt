package com.stavro_xhardha.home_library.ui.book.add_new_item

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import com.stavro_xhardha.home_library.model.Book
import com.stavro_xhardha.home_library.repository.BookRepository

class AddNewItemViewModel(application: Application) : AndroidViewModel(application) {
    private val bookRepository: BookRepository

    init {
        bookRepository = BookRepository(application)
    }

    fun insertNote(book: Book) {
        InsertAsync(bookRepository).execute(book)
    }

    class InsertAsync(val bookRepository: BookRepository) : AsyncTask<Book, Void, Unit>() {

        override fun doInBackground(vararg params: Book?) {
            params[0]?.let { bookRepository.insert(it) }
        }

    }

}