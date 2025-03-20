package com.example.surf.ui.favorite_screen

import androidx.lifecycle.ViewModel
import com.example.surf.data.book_model.BookData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FavoriteScreenViewModel : ViewModel() {
    private var _favoriteScreenState = MutableStateFlow(FavoriteScreenState())
    val favoriteScreenState: StateFlow<FavoriteScreenState> = _favoriteScreenState.asStateFlow()

    fun addToFavoriteList(book: BookData) : Boolean
    {
        if(!_favoriteScreenState.value.favoriteIds.contains(book.id))
        {
            _favoriteScreenState.value.favoriteList.add(book)
            return true
        }
        else return false
    }

    fun deleteFromFavoriteList(book: BookData) : Boolean
    {
        if(!_favoriteScreenState.value.favoriteIds.contains(book.id))
        {
            _favoriteScreenState.value.favoriteList.remove(book)
            return true
        }
        else return false
    }
}