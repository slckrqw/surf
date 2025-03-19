package com.example.surf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.surf.navigation.NaviBar
import com.example.surf.navigation.NaviConstants
import com.example.surf.navigation.Screen
import com.example.surf.search_screen.SearchScreen
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

    Scaffold(
        bottomBar = {
            NaviBar(
                navController = navController,
                naviBarItems = NaviConstants.BottomNaviItems
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Search.value,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() },
            popEnterTransition = { fadeIn() },
            popExitTransition = { fadeOut() },
            modifier = Modifier.padding(it)
        ) {
            composable(Screen.Search.value) {
                SearchScreen()
            }
            composable(Screen.Favorite.value) {
                FavoriteScreen()
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