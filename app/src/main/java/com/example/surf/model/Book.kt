package com.example.surf.model

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("volumeInfo")
    val data: BookData
)
