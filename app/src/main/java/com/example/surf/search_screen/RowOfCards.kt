package com.example.surf.search_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.surf.model.BookData

@Composable
fun RowOfCards(
    book1: BookData,
    book2: BookData?,
    navigateToBook: (BookData) -> Unit
){
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        BookCard(
            book = book1,
            startPadding = 20.dp,
            endPadding = 6.dp,
            navigateToBook = navigateToBook
        )
        if(book2 == null){
            Spacer(
                modifier = Modifier.weight(1f)
            )
        }
        else BookCard(
            book = book2,
            startPadding = 6.dp,
            endPadding = 20.dp,
            navigateToBook = navigateToBook
        )
    }
}