package com.ddstudio.data.remote.api

import com.ddstudio.data.remote.dto.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("ar2code/apitest/master/movies.json")
    suspend fun getMovies() : Response<MutableList<MovieResponse>>
}