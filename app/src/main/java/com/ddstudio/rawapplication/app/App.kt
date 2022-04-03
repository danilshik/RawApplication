package com.ddstudio.rawapplication.app

import android.app.Application
import com.ddstudio.domain.di.DaggerDomainComponent
import com.ddstudio.rawapplication.di.AppComponent
import com.ddstudio.rawapplication.di.DaggerAppComponent
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var injector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return injector
    }



    override fun onCreate() {
        super.onCreate()

        getAppComponent().inject(this)
    }

    private fun getAppComponent(): AppComponent {
        val dataComponent = DaggerDataComponent
            .factory()
            .build()

        val domainComponent = DaggerDomainComponent
            .factory()
            .build(dataComponent.provideGitHubReposRepository())

        val appComponent = DaggerAppComponent
            .factory()
            .build(this, domainComponent)
        appComponent.inject(this)

        return appComponent
    }
}