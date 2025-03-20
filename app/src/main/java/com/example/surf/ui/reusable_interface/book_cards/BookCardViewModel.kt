package com.example.surf.ui.reusable_interface.book_cards

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.surf.data.book_model.BookData
import com.example.surf.data.database.BookEntity
import com.example.surf.data.database.repository.BooksRepository
import kotlinx.coroutines.flow.firstOrNull

/*class BookCardViewModel(private val booksRepository: BooksRepository) : ViewModel() {

    fun BookData.toBookEntity(): BookEntity = BookEntity(
        id = id,
        title = title,
        author = authors?.get(0),
        publishedDate = publishedDate,
        description = description,
        imageLinks = imageLinks
    )

    suspend fun addToFavorite(book: BookData){
        booksRepository.insertBook(book.toBookEntity())
    }

    suspend fun deleteFromFavorite(book: BookData){
        booksRepository.deleteBook(book.toBookEntity())
    }

    suspend fun isFavorite(id: String): Boolean{
        val book = booksRepository.getBookStream(id).firstOrNull()

        return book != null
    }
}*/