package com.example.surf.ui.search_screen

import com.example.surf.data.Book

data class SearchScreenState (
    val books: List<Book> = listOf(),
    val searchValue: String = ""
)