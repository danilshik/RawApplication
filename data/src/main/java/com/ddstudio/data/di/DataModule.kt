package com.ddstudio.data.di

import android.content.Context
import androidx.room.Room
import com.ddstudio.data.db.AppDatabase
import com.ddstudio.data.db.LocalDataSource
import com.ddstudio.data.db.dao.MovieDao
import com.ddstudio.data.remote.OkHttpClientBuilder
import com.ddstudio.data.remote.RetrofitBuilder
import com.ddstudio.data.remote.api.ApiService
import com.ddstudio.data.remote.remotedatasource.MovieRemoteDataSource
import com.ddstudio.data.repositories.MovieRepositoryImpl
import com.ddstudio.domain.repositories.MovieRepository
import com.ddstudio.domain.utils.APP_DB
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
class DataModule(val context: Context) {
    @DataScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClientBuilder().okHttpClientInstance
    }

    @DataScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return RetrofitBuilder(okHttpClient).retrofitInstance
    }

    @DataScope
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @DataScope
    @Provides
    fun provideMovieRemoteDataSource(apiService: ApiService): MovieRemoteDataSource {
        return MovieRemoteDataSource(apiService)
    }

    @DataScope
    @Provides
    fun provideMovieRepoRepositoryImpl(
        movieRemoteDataSource: MovieRemoteDataSource,
        localDataSource: LocalDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, localDataSource)
    }

    @Provides
    @DataScope
    fun provideDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context, AppDatabase::class.java,
            APP_DB
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @DataScope
    fun provideMovieDao(db: AppDatabase): MovieDao = db.getMovieDao()

    @Provides
    @DataScope
    fun provideLocalDataSource(
        movieDao: MovieDao
    ) = LocalDataSource(movieDao)
}