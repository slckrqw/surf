package com.example.surf.data.database.repository

import com.example.surf.data.database.BookDao
import com.example.surf.data.database.BookEntity
import kotlinx.coroutines.flow.Flow

class OfflineBooksRepository(private val bookDao: BookDao) : BooksRepository {
    override fun getAllBooksStream(): Flow<List<BookEntity>> = bookDao.getAllBooks()

    override fun getBookStream(id: String): Flow<BookEntity?> = bookDao.getBook(id)

    override suspend fun insertBook(book: BookEntity) = bookDao.insert(book)

    override suspend fun deleteBook(book: BookEntity) = bookDao.delete(book)

    override suspend fun updateBook(book: BookEntity) = bookDao.update(book)
}