package com.stavro_xhardha.todo.ui.todo

import android.app.Application
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

    fun insertNote(note: Note) {
        notesRepository.insert(note)
    }
}
