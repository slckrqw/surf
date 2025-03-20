package com.example.surf.ui.reusable_interface.book_cards

import android.database.sqlite.SQLiteConstraintException
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
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
import kotlinx.coroutines.launch

@Composable
fun RowScope.BookCard(
    book: BookData,
    startPadding: Dp,
    endPadding: Dp,
    navigateToBook: (BookData) -> Unit,
    //vm: BookCardViewModel = viewModel()
){
    val textStyle = TextStyle(
        fontSize = 14.sp,
        fontFamily = robotoFamily,
        fontWeight = FontWeight.W400
    )
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current


    Card(
       modifier = Modifier
           .padding(start = startPadding, end = endPadding, bottom = 20.dp, top = 12.dp)
           .height(290.dp)
           .weight(1f)
           .clickable(
               onClick = {
                   navigateToBook(book)
               }
           ),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        shape = RectangleShape
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
                if(book.imageLinks?.thumbnail != null){
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
                            .fillMaxSize()
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
                else{
                    Spacer(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(16.dp))
                            .background(LightGray)
                    )
                }
                IconButton(
                    onClick = {
                        /*coroutineScope.launch {
                            try {
                                if (vm.isFavorite(book.id)) {
                                    vm.deleteFromFavorite(book)
                                    Toast.makeText(context, "Книга успешно добавлена в избранное", Toast.LENGTH_SHORT).show()
                                }
                                else {
                                    vm.addToFavorite(book)
                                    Toast.makeText(context, "Книга успешно удалена из избранного", Toast.LENGTH_SHORT).show()
                                }
                            }
                            catch(e: SQLiteConstraintException){
                                Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show()
                            }
                        }*/
                    },
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
            book.authors?.get(0)?.let {
                Text(
                    text = it,
                    color = DarkGray,
                    style = textStyle,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                )
            }
            book.title?.let {
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