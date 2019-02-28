package com.stavro_xhardha.home_library.ui.book.todo

import android.app.Application
import androidx.lifecycle.ViewModelProviders
import com.stavro_xhardha.home_library.ui.book.TodoViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class BookFragmentModule {

    @Provides
    internal fun provideTodoViewModelFactory(application: Application) = TodoViewModelFactory(application)

    @Provides
    internal fun provideTodoViewModel(viewModelFactory: TodoViewModelFactory, context: BooksFragment): BookViewModel =
        ViewModelProviders.of(context, viewModelFactory).get(BookViewModel::class.java)
}
