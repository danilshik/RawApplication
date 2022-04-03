package com.ddstudio.data.remote.remotedatasource

import com.ddstudio.data.remote.api.ApiService
import com.ddstudio.data.remote.dto.MovieResponse
import com.ddstudio.domain.common.base.BaseResult
import com.ddstudio.domain.common.base.ErrorResult
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val apiService: ApiService) : BaseRemoteDataSource(){

    suspend fun fetchAllMovies() = getResponse { apiService.getMovies() }
}