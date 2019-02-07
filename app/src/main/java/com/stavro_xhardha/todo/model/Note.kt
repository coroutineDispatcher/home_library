package com.stavro_xhardha.todo.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @NonNull
    @ColumnInfo(name = "book_title")
    var title: String,

    @NonNull
    @ColumnInfo(name = "book_author")
    var author: String,

    @NonNull
    @ColumnInfo(name = "book_type")
    var type: String
)