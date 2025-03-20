package com.example.surf.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookData(
    @SerializedName("title")
    val title: String? = "Фантастические звери и места их обитания.",
    @SerializedName("authors")
    val authors: List<String>? = listOf("Ньют Скамандер"),
    @SerializedName("publishedDate")
    val publishedDate: String? = "2017",
    @SerializedName("description")
    val description: String? = "Книга дает возможность юным читателям еще больше узнать о любимом герое Гарри Поттере, снова соприкоснуться с магией",
    @SerializedName("imageLinks")
    val imageLinks: ImageLink? = ImageLink()
): Parcelable
