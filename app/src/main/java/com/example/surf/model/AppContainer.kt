package com.example.surf.model

import android.content.Context

interface AppContainer{
    val booksRepository: BooksRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val booksRepository: BooksRepository by lazy {
        OfflineBooksRepository(BooksDatabase.getDatabase(context).bookDao())
    }
}