package com.stavro_xhardha.home_library.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {
    @Query(" Select * from notes order by book_author")
    fun getAllNotes(): LiveData<List<Book>>

    @Insert
    fun insertNewNote(book: Book)

    @Delete
    fun delete(book: Book)
}