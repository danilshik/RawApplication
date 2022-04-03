package com.ddstudio.domain.di

import android.util.Log
import com.ddstudio.domain.repositories.MovieRepository
import com.ddstudio.domain.usecases.MovieUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideMovieUseCase(movieUseRepository: MovieRepository): MovieUseCase {
        return MovieUseCase(movieUseRepository)
    }
}