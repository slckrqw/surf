package com.example.surf.ui.favorite_screen

import com.example.surf.data.book_model.BookData

data class FavoriteScreenState(
    val favoriteList: MutableList<BookData> = mutableListOf(),
    val favoriteIds: HashSet<String> = hashSetOf<String>()
)
