package com.example.movies.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.movies.MainViewModel

@Composable
fun DetailsScreen(navController: NavHostController, viewModel: MainViewModel,itemId:String){
Text("ID: $itemId")
}