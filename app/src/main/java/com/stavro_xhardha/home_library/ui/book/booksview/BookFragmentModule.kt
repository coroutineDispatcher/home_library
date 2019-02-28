package com.stavro_xhardha.home_library.ui.book.booksview

import android.app.Application
import androidx.lifecycle.ViewModelProviders
import com.stavro_xhardha.home_library.ui.book.BookViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class BookFragmentModule {

    @Provides
    internal fun provideTodoViewModelFactory(application: Application) = BookViewModelFactory(application)

    @Provides
    internal fun provideTodoViewModel(viewModelFactory: BookViewModelFactory, context: BooksFragment): BookViewModel =
        ViewModelProviders.of(context, viewModelFactory).get(BookViewModel::class.java)
}
