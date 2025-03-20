package com.example.surf.data.database.repository

import com.example.surf.data.database.BookEntity
import kotlinx.coroutines.flow.Flow

interface BooksRepository{

    fun getAllBooksStream(): Flow<List<BookEntity>>

    fun getBookStream(id: String): Flow<BookEntity?>

    suspend fun insertBook(book: BookEntity)

    suspend fun deleteBook(book: BookEntity)

    suspend fun updateBook(book: BookEntity)
}