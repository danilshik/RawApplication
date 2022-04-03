package com.ddstudio.data.di

import com.ddstudio.domain.repositories.MovieRepository
import dagger.Component

@DataScope
@Component(modules = [DataModule::class])
interface DataComponent {

    @Component.Factory
    interface Factory {
        fun build(): DataComponent
    }

    fun provideMovieRepository() : MovieRepository
}