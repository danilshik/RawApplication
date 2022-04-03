package com.ddstudio.rawapplication.ui.di

import com.ddstudio.rawapplication.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiBindingModule {
    @ContributesAndroidInjector(modules = [PresenterModule::class])
    internal abstract fun mainActivity(): MainActivity
}