package com.stavro_xhardha.todo.ui.todo

import androidx.lifecycle.ViewModel
import com.stavro_xhardha.todo.model.Note

class TodoViewModel : ViewModel() {

    //private val notesRepository: NotesRepository
    // internal var notesList: LiveData<List<Note>>

    init {
        // notesRepository = NotesRepository(application)
        //    notesList = notesRepository.getAllNotes()
    }

    fun insertNote(note: Note) {
        //    notesRepository.insert(note)
    }
}
