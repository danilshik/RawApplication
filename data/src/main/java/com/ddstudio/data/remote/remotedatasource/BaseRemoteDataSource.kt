package com.ddstudio.data.remote.remotedatasource

import com.ddstudio.domain.common.base.BaseResult
import com.ddstudio.domain.common.base.ErrorResult
import retrofit2.Response

abstract class BaseRemoteDataSource {
    protected suspend fun <T : Any> getResponse(call :suspend () -> Response<T>): BaseResult<T> {
        return try{
            val response = call()
            if(response.isSuccessful){
                val body = response.body()
                if(body != null){
                    return BaseResult.Success(body)
                }
            }
            BaseResult.Error(
                ErrorResult(
                    code = response.code(),
                    message = response.message()
                )
            )
        } catch (e : Exception){
            BaseResult.Error(
                ErrorResult(
                    throwable = e
                )
            )
        }
    }
}