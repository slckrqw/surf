package com.example.surf.search_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.surf.model.BookData

@Composable
fun RowOfCards(
    book1: BookData,
    book2: BookData?
){
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        BookCard(
            thumbnail = book1.imageLinks?.thumbnail,
            author = book1.authors?.get(0),
            title = book1.title
        )
        if(book2 == null){
            Spacer(
                modifier = Modifier.weight(1f)
            )
        }
        else BookCard(
            thumbnail = book2.imageLinks?.thumbnail,
            author = book2.authors?.get(0),
            title = book2.title
        )
    }
}