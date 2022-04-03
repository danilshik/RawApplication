package com.ddstudio.data.db

import com.ddstudio.data.db.dao.MovieDao
import com.ddstudio.data.db.entities.MovieDb
import javax.inject.Inject

class LocalDataSource constructor(
    private val movieDao: MovieDao
) {

    fun getAllMovies() = movieDao.getAll()

    fun insertAll(movies : List<MovieDb>) = movieDao.insertAll(movies)
}