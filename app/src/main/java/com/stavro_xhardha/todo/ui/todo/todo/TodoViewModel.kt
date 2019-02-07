package com.stavro_xhardha.todo.ui.todo.todo

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.stavro_xhardha.todo.model.Note
import com.stavro_xhardha.todo.repository.NotesRepository


class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val notesRepository: NotesRepository
    internal var notesList: LiveData<List<Note>>

    init {
        notesRepository = NotesRepository(application)
        notesList = notesRepository.getAllNotes()
    }

    fun deleteNote(note: Note) {
        DeleteAsync(notesRepository).execute(note)
    }

    class DeleteAsync(val notesRepository: NotesRepository) : AsyncTask<Note, Void, Unit>() {

        override fun doInBackground(vararg params: Note?) {
            params[0]?.let { notesRepository.deleteNote(it) }
        }

    }
}
