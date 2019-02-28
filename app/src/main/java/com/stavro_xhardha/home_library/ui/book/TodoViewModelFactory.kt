package com.stavro_xhardha.home_library.ui.book

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stavro_xhardha.home_library.ui.book.todo.BookViewModel

class TodoViewModelFactory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookViewModel(application) as T
    }
}