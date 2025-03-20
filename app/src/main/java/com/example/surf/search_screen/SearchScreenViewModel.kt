package com.example.surf.search_screen

import androidx.lifecycle.ViewModel
import com.example.surf.interfaces.BooksApi
import com.example.surf.model.BooksResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchScreenViewModel: ViewModel(){

    private var _searchUiState = MutableStateFlow(SearchScreenState())
    val searchUiState: StateFlow<SearchScreenState> = _searchUiState.asStateFlow()


    fun searchBooks(query: String) {
        val call = BooksApi.retrofitService.searchVolumes(query)
        call.enqueue(
            object : Callback<BooksResponse> {
                override fun onResponse(
                    call: Call<BooksResponse>,
                    response: Response<BooksResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        _searchUiState.update {
                            it.copy(
                                books = response.body()?.books ?: emptyList()
                            )
                        }
                        setIds()
                    }
                }

                override fun onFailure(call: Call<BooksResponse>, t: Throwable) {

                }
            }
        )
    }

    fun updateSearchValue(newValue: String){
        _searchUiState.update {
            it.copy(
                searchValue = newValue
            )
        }
    }

    fun eraseSearchValue(){
        _searchUiState.update {
            it.copy(
                books = emptyList(),
                searchValue = ""
            )
        }
    }

    fun setIds(){
       /* _searchUiState.value.books.forEach { book->
            var id = (1..1000000000).random()
            while(_searchUiState.value.usedIds.contains(id))
            {
                id = (1..1000000000).random()
            }

            book.data.localId = id
        }*/
    }
}