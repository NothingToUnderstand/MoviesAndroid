package com.example.movies.screens

import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import coil.compose.rememberImagePainter
import com.example.movies.MainViewModel

@Composable
fun DetailsScreen(viewModel: MainViewModel, itemId: String) {
    val item = viewModel
        .allMovies
        .observeAsState(listOf())
        .value
        .firstOrNull() {
            it.id == itemId.toInt()
        }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                vertical = 24.dp,
                horizontal = 8.dp
            )
    ) {
        LazyColumn {
            item {


                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = rememberImagePainter(item?.image?.medium),
                        contentDescription = null,
                        modifier = Modifier
                            .size(512.dp)
                    )
                    Text(
                        item?.name ?: " ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Row(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Rating: ", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(item?.rating.toString())
                    }
                    Row(
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Text(" Genre: ", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        item?.genres?.take(2)?.forEach {
                            Text(" $it ")
                        }
                    }
                    HtmlText(html = item?.summary ?: "", Modifier.padding(top = 10.dp))
                }
            }
        }
    }
}

@Composable
fun HtmlText(html: String, modifier: Modifier) {
    AndroidView(modifier = modifier,
        factory = { context -> TextView(context) },
        update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT) }
    )
}


