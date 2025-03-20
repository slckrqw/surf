package com.example.surf.ui.reusable_interface.bars

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.surf.data.navigation.NaviBarItem
import com.example.surf.ui.theme.Blue
import com.example.surf.ui.theme.Gray
import com.example.surf.ui.theme.SurfTheme
import com.example.surf.ui.theme.White
import com.example.surf.ui.theme.robotoFamily

@Composable
fun NaviBar(
    navController: NavController,
    naviBarItems: List<NaviBarItem>
){
    NavigationBar(
        containerColor = White,
        modifier = Modifier
            .height(80.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        naviBarItems.forEach { item->
            NavigationBarItem(
                selected = item.route.value == currentRoute,
                onClick = {
                    navController.navigate(item.route.value)
                },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.text),
                        fontSize = 12.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.W500
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedIconColor = Gray,
                    selectedIconColor = Blue,
                    unselectedTextColor = Gray,
                    selectedTextColor = Blue,
                    indicatorColor = White
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NaviBarPreview() {
    SurfTheme {
        /*NaviBar(
            NaviConstants.BottomNaviItems
        )*/
    }
}