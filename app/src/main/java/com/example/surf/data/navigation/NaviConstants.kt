package com.example.surf.data.navigation

import com.example.surf.R

object NaviConstants {
    val BottomNaviItems = listOf(
        NaviBarItem(
            icon = R.drawable.search_icon,
            text = R.string.bar_item_search,
            route = Screen.Search
        ),
        NaviBarItem(
            icon = R.drawable.favorite_icon,
            text = R.string.bar_item_favorite,
            route = Screen.Favorite
        )
    )
}