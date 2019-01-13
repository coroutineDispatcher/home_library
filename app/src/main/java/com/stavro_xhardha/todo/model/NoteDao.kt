package com.stavro_xhardha.todo.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query(" Select * from notes order by id desc")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert
    fun insertNewNote(note: Note)

    @Delete
    fun delete(note: Note)
}