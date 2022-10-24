package com.example.movies.data.network

import com.example.movies.data.models.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/shows/1")
    suspend fun getAllMovies():Response<List<Movies>>
}