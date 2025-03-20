package com.example.surf.search_screen

import androidx.collection.emptyIntSet
import com.example.surf.model.Book

data class SearchScreenState (
    val books: List<Book> = listOf(),
    val searchValue: String = "",
    val usedIds: HashSet<Int> = hashSetOf<Int>()
)