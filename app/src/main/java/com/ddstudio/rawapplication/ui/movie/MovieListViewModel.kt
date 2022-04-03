package com.ddstudio.rawapplication.ui.movie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ddstudio.domain.common.base.BaseResult
import com.ddstudio.domain.models.Movie
import com.ddstudio.domain.usecases.MovieUseCase
import com.ddstudio.rawapplication.ui.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
): BaseViewModel() {

    private val items = MutableLiveData<MutableList<Movie>>()


    init {
        getAllMovies()
    }

    fun getAllMovies() {
        viewModelScope.launch {
            movieUseCase.getAllMovies().collect {
                Log.d("APP", "getAllMovies: $it")
                if(it is BaseResult.Success){
                    items.value = it.data
                } else if(it is BaseResult.Empty{
                    items.value = mutableListOf()
                }
            }
        }
    }

}