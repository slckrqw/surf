package com.example.surf.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

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
