package com.example.movies.data.network

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllMovies()=apiService.getAllMovies()
}