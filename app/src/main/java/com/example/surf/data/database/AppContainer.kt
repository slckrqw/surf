package com.example.surf.data.database

import android.content.Context
import com.example.surf.data.database.repository.BooksRepository
import com.example.surf.data.database.repository.OfflineBooksRepository

interface AppContainer{
    val booksRepository: BooksRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val booksRepository: BooksRepository by lazy {
        OfflineBooksRepository(BooksDatabase.getDatabase(context).bookDao())
    }
}