package com.ddstudio.data.remote

import com.ddstudio.data.BuildConfig
import okhttp3.OkHttpClient

class OkHttpClientBuilder {
    var okHttpClientInstance: OkHttpClient
        private set

    init {
        val okHttpBuilder = OkHttpClient.Builder()

        if (BuildConfig.BUILD_TYPE != "debug") {
            okHttpBuilder.addInterceptor { chain ->
                println(chain.request())
                chain.proceed(chain.request())
            }
        }
        okHttpClientInstance = okHttpBuilder.build()
    }
}