package com.stavro_xhardha.home_library.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stavro_xhardha.home_library.model.Book
import com.stavro_xhardha.home_library.model.BookDao

@Database(entities = arrayOf(Book::class), version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {
    abstract fun notesDao(): BookDao

    companion object {
        private var INSTANCE: BookDatabase? = null;

        fun getInstance(context: Context): BookDatabase? {
            if (INSTANCE == null) {
                synchronized(BookDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, BookDatabase::class.java, "notes_db")
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