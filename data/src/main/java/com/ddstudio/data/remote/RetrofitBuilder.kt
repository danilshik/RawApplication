package com.ddstudio.data.remote

import com.ddstudio.data.remote.api.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitBuilder(okHttpClient: OkHttpClient) {

    var retrofitInstance: Retrofit
        private set

    init {
        retrofitInstance = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(
                        KotlinJsonAdapterFactory()
                    ).build()))
            .client(okHttpClient)
            .build()
    }

    fun getApiService(): ApiService =
        retrofitInstance.create(ApiService::class.java)

    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/"
    }
}