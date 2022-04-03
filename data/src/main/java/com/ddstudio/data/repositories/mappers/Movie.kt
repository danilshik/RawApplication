package com.ddstudio.data.repositories.mappers

import com.ddstudio.data.db.entities.MovieDb
import com.ddstudio.data.remote.dto.MovieResponse
import com.ddstudio.domain.models.Movie

fun MovieResponse.to() = Movie(
    id = id,
    poster = poster,
    year = year
)

fun List<MovieResponse>.to(): List<Movie> {
    return this.map {
        it.to()
    }
}

fun MovieResponse.toDb() = MovieDb(
    id = id,
    poster = poster,
    year = year
)

fun MovieDb.toModel() = Movie(
    id = id,
    poster = poster,
    year = year
)

fun List<MovieDb>.toModel(): List<Movie> {
    return this.map { it.toModel() }
}

fun Movie.toDb() = MovieDb(
    id = id,
    poster = poster,
    year = year
)