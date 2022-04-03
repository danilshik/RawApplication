package com.ddstudio.domain.di

import com.ddstudio.domain.repositories.MovieRepository
import com.ddstudio.domain.usecases.MovieUseCase
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class])
interface DomainComponent {

    @Component.Factory
    interface Factory {
        fun build(@BindsInstance movieRepository: MovieRepository): DomainComponent
    }

    fun provideMovieUseCase(): MovieUseCase
}