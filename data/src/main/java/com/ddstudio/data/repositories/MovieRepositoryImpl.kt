package com.ddstudio.data.repositories

import com.ddstudio.data.db.LocalDataSource
import com.ddstudio.data.db.dao.MovieDao
import com.ddstudio.data.remote.remotedatasource.MovieRemoteDataSource
import com.ddstudio.data.repositories.mappers.toDb
import com.ddstudio.data.repositories.mappers.toModel
import com.ddstudio.domain.common.base.BaseResult
import com.ddstudio.domain.models.Movie
import com.ddstudio.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val localDataSource: LocalDataSource
) : BaseRepository(), MovieRepository {

    override suspend fun getAllMovies(): Flow<BaseResult<List<Movie>>> {
        return flow {
            val cached = getCachedAllMovies()
            emit(BaseResult.Loading(cached))
            val remoteResult = movieRemoteDataSource.fetchAllMovies()
            if (remoteResult is BaseResult.Success) {
                val result = remoteResult.data
                if (result.isNotEmpty()) {
                    localDataSource.insertAll(result.map { it.toDb() })
                    val newCashed = getCachedAllMovies()
                    if (newCashed.isEmpty()) {
                        emit(BaseResult.Empty)
                    } else {
                        emit(BaseResult.Success(newCashed))
                    }
                } else {
                    emit(BaseResult.Empty)
                }
            } else if (remoteResult is BaseResult.Error) {
                emit(remoteResult)
            }
        }
    }

    fun getCachedAllMovies(): List<Movie> {
        return localDataSource.getAllMovies().map { it.toModel() }
    }


//    fun <DatabaseModel: BaseEntity, RemoteModel: BaseResponse, ResultModel: List<>> getResult(
//        databaseSelectQuery : suspend () -> DatabaseModel,
//        databaseSaveQuery : suspend () -> Unit,
//        remoteQuery : suspend () -> Response<RemoteModel>,
//        mapperDatabaseToModel : () -> ResultModel
//    ){
//        return flow<ResultModel>{
//            emit(BaseResult.Loading())
//            val response = apiCall(remoteQuery)
//            when(response){
//                is BaseResult.Success -> {
//                    databaseSaveQuery()
//                    val resultDatabase = databaseSelectQuery()
//                    if(resultDatabase)
//                }
//            }
//
//        }
//    }
}