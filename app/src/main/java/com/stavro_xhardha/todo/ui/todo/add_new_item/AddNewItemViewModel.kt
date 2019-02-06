package com.stavro_xhardha.todo.ui.todo.add_new_item

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import com.stavro_xhardha.todo.model.Note
import com.stavro_xhardha.todo.repository.NotesRepository

class AddNewItemViewModel(application: Application) : AndroidViewModel(application) {
    private val notesRepository: NotesRepository

    init {
        notesRepository = NotesRepository(application)
    }

    fun insertNote(note: Note) {
        InsertAsync(notesRepository).execute(note)
    }

    class InsertAsync(val notesRepository: NotesRepository) : AsyncTask<Note, Void, Unit>() {

        override fun doInBackground(vararg params: Note?) {
            params[0]?.let { notesRepository.insert(it) }
        }

    }

}