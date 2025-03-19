package com.example.surf.model

import com.google.gson.annotations.SerializedName

data class ImageLink(
    @SerializedName("smallThumbnail")
    val smallThumbnail: String = "http://books.google.com/books/content?id=4KR_kgAACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
    @SerializedName("thumbnail")
    val thumbnail: String = "http://books.google.com/books/content?id=4KR_kgAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
)
