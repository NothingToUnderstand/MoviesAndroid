package com.example.movies.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movies.MainViewModel
import com.example.movies.data.models.Movies

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    allMovies.forEach { Log.d("Movies_Data", "${it.id}, ${it.name}") }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(allMovies) {
                MovieItem(it)
            }
        }

    }
}

@Composable
fun MovieItem(item: Movies) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = item.id.toString())
            Spacer(modifier = Modifier.size(10.dp))
        Text(text = item.name)
    }
}