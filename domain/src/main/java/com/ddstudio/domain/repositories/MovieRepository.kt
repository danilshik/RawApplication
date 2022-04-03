package com.ddstudio.domain.repositories

import com.ddstudio.domain.common.base.BaseResult
import com.ddstudio.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getAllMovies(): Flow<BaseResult<MutableList<Movie>>>
}