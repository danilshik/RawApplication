package com.ddstudio.domain.usecases

import com.ddstudio.domain.repositories.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend fun getAllMovies() =
        movieRepository.getAllMovies()
            .flowOn(Dispatchers.IO)
}