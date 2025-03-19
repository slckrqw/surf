package com.example.surf.model

import com.google.gson.annotations.SerializedName

data class BooksResponse(
    @SerializedName("items")
    val books: List<Book>?
)
