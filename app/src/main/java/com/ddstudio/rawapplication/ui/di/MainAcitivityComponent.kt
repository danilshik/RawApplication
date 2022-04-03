package com.ddstudio.rawapplication.ui.di

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [PresenterModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Factory : AndroidInjector.Builder<MainActivity>() {

        abstract fun injectMainActivityModule(presenterModule: PresenterModule): Factory
    }
}