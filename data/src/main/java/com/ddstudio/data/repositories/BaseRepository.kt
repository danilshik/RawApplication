package com.ddstudio.data.repositories

import com.ddstudio.domain.common.base.BaseResult
import com.ddstudio.domain.common.base.ErrorResult
import com.ddstudio.domain.extensions.getError
import retrofit2.Response

abstract class BaseRepository {
    protected suspend fun <T: Any> apiCall(call : suspend () -> Response<T>) : BaseResult<T> {
        return try {
            val response = call()
            if(response.isSuccessful){
                val body = response.body()
                if(body != null)
                    BaseResult.Success(body)
                else
                    BaseResult.Empty
            } else {
                BaseResult.Error(
                    ErrorResult(
                        code = response.code(),
                        message = response.message(),
                    ),
                )
            }
        } catch (e: Throwable){
            BaseResult.Error(e.getError())
        }
    }
}