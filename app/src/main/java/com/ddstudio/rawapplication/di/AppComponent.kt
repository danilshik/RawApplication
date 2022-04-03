package com.ddstudio.rawapplication.di

import android.app.Application
import android.content.Context
import com.ddstudio.domain.di.DomainComponent
import com.ddstudio.rawapplication.app.App
import com.ddstudio.rawapplication.ui.di.UiBindingModule
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import dagger.android.AndroidInjectionModule


@Component(
    modules = [AndroidInjectionModule::class, UiBindingModule::class],
    dependencies = [DomainComponent::class]
)

interface AppComponent {
    fun inject(app : App)

    @Component.Factory
    interface Factory {
        fun build(
            @BindsInstance context: Context,
            domainComponent: DomainComponent
        ): AppComponent
    }

    fun getContext(): Context
}