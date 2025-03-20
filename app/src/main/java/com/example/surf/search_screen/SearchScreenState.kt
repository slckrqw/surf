package com.example.surf.search_screen

import com.example.surf.model.Book

data class SearchScreenState (
    val books: List<Book> = listOf(),
    val searchValue: String = ""
)