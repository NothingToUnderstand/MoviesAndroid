package com.example.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.Movies
import com.example.movies.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repo:ApiRepository): ViewModel(){
    private val _allMovies=MutableLiveData<List<Movies>>()
    val allMovies:LiveData<List<Movies>>
        get()=_allMovies


    fun getAllMovies(){
        viewModelScope.launch {
            repo.getAllMovies().let {
                if (it.isSuccessful){
                    Log.d("Check_Data","${it.body()}")
                    _allMovies.postValue(it.body())
                } else{
                    Log.e("Check_Data","Failed to get data, error: ${it.errorBody()}")
                }
            }
        }
    }
}