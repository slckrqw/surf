package com.example.surf.navigation

open class Screen (val route: String) {
    object Search: Screen("search")
    object Favorite: Screen("favorite")
}