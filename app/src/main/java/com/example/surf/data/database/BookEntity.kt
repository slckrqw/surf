package com.example.surf.data.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.surf.data.book_model.ImageLink

@Entity(tableName = "books")
data class BookEntity(

    @PrimaryKey(autoGenerate = false)
    val id: String = "",

    val title: String?,
    val author: String?,
    val publishedDate: String?,
    val description: String?,
    @Embedded
    val imageLinks: ImageLink?
)