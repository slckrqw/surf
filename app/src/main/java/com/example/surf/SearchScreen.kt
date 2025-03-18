package com.example.surf

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.surf.ui.theme.SurfTheme
import com.example.surf.ui.theme.White

@Composable
fun SearchScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SurfTheme {
        SearchScreen()
    }
}