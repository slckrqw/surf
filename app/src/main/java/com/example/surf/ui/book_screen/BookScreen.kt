package com.example.surf.ui.book_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.surf.R
import com.example.surf.data.book_model.BookData
import com.example.surf.ui.theme.Black
import com.example.surf.ui.theme.DarkGray
import com.example.surf.ui.theme.Gray
import com.example.surf.ui.theme.LightGray
import com.example.surf.ui.theme.SurfTheme
import com.example.surf.ui.theme.White
import com.example.surf.ui.theme.robotoFamily

@Composable
fun BookScreen(
    book: BookData?,
    returnBack: () -> Unit,
    addToFavorite: (BookData) -> Unit = {}
){
    Column(
        modifier = Modifier
            .background(White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    returnBack()
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = White
                ),
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(24.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.arrow_back_icon),
                    contentDescription = null,
                    tint = Black
                )
            }
            IconButton(
                onClick = {
                    //TODO
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = White
                ),
                modifier = Modifier
                    .padding(end= 20.dp)
                    .shadow(
                        elevation = 2.dp,
                        shape = CircleShape,
                        clip = true
                    )
                    .size(24.dp)

            ) {
                Icon(
                    painter = painterResource(R.drawable.favorite_icon),
                    contentDescription = null,
                    tint = Gray
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(top = 12.dp, bottom = 14.dp)
                .width(200.dp)
                .height(300.dp)
                .clip(RoundedCornerShape(24.dp)),
        ) {
            if (book?.imageLinks?.thumbnail != null) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(book.imageLinks.thumbnail)
                        .diskCachePolicy(CachePolicy.ENABLED)
                        .memoryCachePolicy(CachePolicy.ENABLED)
                        .apply {
                            networkCachePolicy(CachePolicy.ENABLED)
                        }
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } else Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Gray),
            )
        }
        book?.authors?.get(0)?.let{
            Text(
                text = it,
                fontSize = 16.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.W400,
                color = DarkGray,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        book?.title?.let{
            Text(
                text = it,
                fontSize = 16.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.W700,
                color = Black,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 8.dp),
                textAlign = TextAlign.Center
            )
        }
        book?.publishedDate?.let{
            Text(
                text = it,
                fontSize = 14.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.W400,
                color = DarkGray,
                overflow = TextOverflow.Ellipsis
            )
        }
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = LightGray
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .height(238.dp)
                ) {
                    Text(
                        text = stringResource(R.string.description_title),
                        fontSize = 16.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.W700,
                        color = Black,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    book?.description?.let {
                        Text(
                            text = it,
                            fontSize = 14.sp,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.W400,
                            color = Black,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookScreenPreview() {
    SurfTheme {
        BookScreen(
            BookData(),
            returnBack = {}
        )
    }
}