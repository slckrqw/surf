package com.example.surf.navigation

open class Screen (val value: String) {
    object Search: Screen("search")
    object Favorite: Screen("favorite")
    object Book: Screen("book")
}