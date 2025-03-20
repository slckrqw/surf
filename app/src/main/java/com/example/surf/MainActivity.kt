package com.example.surf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.surf.ui.book_screen.BookScreen
import com.example.surf.data.book_model.BookData
import com.example.surf.ui.reusable_interface.bars.NaviBar
import com.example.surf.data.navigation.NaviConstants
import com.example.surf.data.navigation.Screen
import com.example.surf.ui.favorite_screen.FavoriteScreen
import com.example.surf.ui.search_screen.SearchScreen
import com.example.surf.ui.search_screen.SearchScreenViewModel
import com.example.surf.ui.theme.SurfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}

@Composable
fun Main(){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    val searchScreenViewModel: SearchScreenViewModel = viewModel()

    Scaffold(
        bottomBar = {
            if(currentDestination != Screen.Book.value) {
                NaviBar(
                    navController = navController,
                    naviBarItems = NaviConstants.BottomNaviItems
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Search.value,
            /*enterTransition = { fadeIn() },
            exitTransition = { fadeOut() },
            popEnterTransition = { fadeIn() },
            popExitTransition = { fadeOut() },*/
            modifier = Modifier.padding(it)
        ) {
            composable(Screen.Search.value) {
                SearchScreen(
                    vm = searchScreenViewModel,
                    navigateToBook = {
                        navController.currentBackStackEntry?.savedStateHandle?.set("book", it)
                        navController.navigate(Screen.Book.value)
                    }
                )
            }
            composable(Screen.Favorite.value) {
                FavoriteScreen()
            }
            composable(Screen.Book.value){
                val currentBook: BookData? = navController.previousBackStackEntry?.savedStateHandle?.get("book")
                BookScreen(
                    currentBook,
                    returnBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SurfTheme {
        Main()
    }
}