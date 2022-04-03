package com.ddstudio.rawapplication.presentation.di

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideViewModelFactory(githubReposUseCase: GetRemoteStarredReposUseCase): ReposViewModelFactory {
        return ReposViewModelFactory(githubReposUseCase)
    }
}