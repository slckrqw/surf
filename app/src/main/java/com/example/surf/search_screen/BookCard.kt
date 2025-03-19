package com.example.surf.search_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.surf.R
import com.example.surf.model.ImageLink
import com.example.surf.ui.theme.Black
import com.example.surf.ui.theme.DarkGray
import com.example.surf.ui.theme.Gray
import com.example.surf.ui.theme.SurfTheme
import com.example.surf.ui.theme.White
import com.example.surf.ui.theme.robotoFamily

@Composable
fun RowScope.BookCard(
    thumbnail: String?,
    author: String?,
    title: String?
){
    val textStyle = TextStyle(
        fontSize = 14.sp,
        fontFamily = robotoFamily,
        fontWeight = FontWeight.W400
    )
    Card(
       modifier = Modifier
           .height(290.dp)
           .weight(1f),
        colors = CardDefaults.cardColors(
            containerColor = White
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            Box(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .height(230.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                thumbnail?.let {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(thumbnail)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
                IconButton(
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = White
                    ),
                    modifier = Modifier
                        .padding(end = 9.dp, top = 7.dp)
                        .size(24.dp)
                ){
                    Icon(
                        painter = painterResource(R.drawable.favorite_icon),
                        contentDescription = null,
                        tint = Gray
                    )
                }
            }
            author?.let {
                Text(
                    text = it,
                    color = DarkGray,
                    style = textStyle,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                )
            }
            title?.let {
                Text(
                    text = it,
                    color = Black,
                    style = textStyle
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookCardPreview() {
    SurfTheme {
        /*BookCard(
            thumbnail = ImageLink().thumbnail,
            author = "J. K. Rowling",
            title = "Гарри Поттер и тайная комната"
        )*/
    }
}