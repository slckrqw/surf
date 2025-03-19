package com.example.surf.model

import com.google.gson.annotations.SerializedName

data class BookData(
    @SerializedName("title")
    val title: String?,
    @SerializedName("authors")
    val authors: List<String>?,
    @SerializedName("publishedDate")
    val publishedDate: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("imageLinks")
    val imageLinks: ImageLink?
)
