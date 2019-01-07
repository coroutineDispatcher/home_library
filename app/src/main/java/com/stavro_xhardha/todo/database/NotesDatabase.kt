package com.stavro_xhardha.todo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stavro_xhardha.todo.model.Note
import com.stavro_xhardha.todo.model.NoteDao

@Database(entities = arrayOf(Note::class), version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NoteDao

    companion object {
        private var INSTANCE: NotesDatabase? = null;

        fun getInstance(context: Context): NotesDatabase? {
            if (INSTANCE == null) {
                synchronized(NotesDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, NotesDatabase::class.java, "notes_db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE;
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}