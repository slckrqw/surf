package com.example.surf.data

import com.example.surf.data.book_model.BookData
import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("volumeInfo")
    val data: BookData
)