package com.stavro_xhardha.todo.ui.todo.todo

import android.app.Application
import androidx.lifecycle.ViewModelProviders
import com.stavro_xhardha.todo.ui.todo.TodoViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TodoFragmentModule {

    @Provides
    internal fun provideTodoViewModelFactory(application: Application) = TodoViewModelFactory(application)

    @Provides
    internal fun provideTodoViewModel(viewModelFactory: TodoViewModelFactory, context: TodoFragment): TodoViewModel =
        ViewModelProviders.of(context, viewModelFactory).get(TodoViewModel::class.java)
}
