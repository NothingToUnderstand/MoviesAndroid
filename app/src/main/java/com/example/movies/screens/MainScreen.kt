package com.example.movies.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.movies.MainViewModel
import com.example.movies.data.models.Movies
import com.example.movies.navigation.Screens

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(20.dp)
        ) {
            items(allMovies) {
                MovieItem(it,navController)
            }
        }

    }
}


@Composable
fun MovieItem(item: Movies, navController: NavHostController) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
                navController.navigate(Screens.Details.route + "/${item.id}")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Image(
                painter = rememberImagePainter(item.image.medium),
                contentDescription =null,
            modifier = Modifier
                .size(128.dp)
            )
            Column {
                Text(item.name, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Row {
                    Text("Rating: ", fontWeight = FontWeight.Bold)
                    Text(item.rating.toString())
                }
                Row {
                    Text("Genre: ", fontWeight = FontWeight.Bold)
                    item.genres.take(2).forEach{ Text(" $it ")}
                }
                Row {
                    Text("Premiered: ", fontWeight = FontWeight.Bold)
                    Text(item.premiered)
                }
            }
        }
    }
}