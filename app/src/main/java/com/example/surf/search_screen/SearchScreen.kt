package com.example.surf.search_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.surf.R
import com.example.surf.model.BookData
import com.example.surf.top_bars.SearchTopBar
import com.example.surf.ui.theme.Black
import com.example.surf.ui.theme.SurfTheme
import com.example.surf.ui.theme.White
import com.example.surf.ui.theme.robotoFamily

@Composable
fun SearchScreen(
    vm: SearchScreenViewModel = viewModel()
){
    val focusManager = LocalFocusManager.current
    var searchValue by remember{
        mutableStateOf("")
    }
    val state = vm.searchUiState.collectAsState()
    Column(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchTopBar(
            focusManager = focusManager,
            value = searchValue,
            onValueChange = {searchValue = it},
            sendRequest = {vm.searchBooks(it)}
        )
        if(searchValue.isEmpty()){
            Box(
                modifier = Modifier
                    .width(250.dp)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.empty_search_line),
                    fontSize = 18.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.W400,
                    color = Black,
                    textAlign = TextAlign.Center
                )
            }
        }
        else if(!state.value.books.isEmpty()){
            LazyColumn {
                items(state.value.books.size){ book->
                    if(book %2 == 0){
                        val book1 = state.value.books[book].data
                        val book2 = if(book+1 < state.value.books.size) state.value.books[book+1].data else null

                        RowOfCards(
                            book1 = book1,
                            book2 = book2
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SurfTheme {
        SearchScreen()
    }
}