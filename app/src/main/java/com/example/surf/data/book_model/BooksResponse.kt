package com.example.surf.data.book_model

import com.example.surf.data.Book
import com.google.gson.annotations.SerializedName

data class BooksResponse(
    @SerializedName("items")
    val books: List<Book>?
)
