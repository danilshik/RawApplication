package com.ddstudio.domain.extensions

import com.ddstudio.domain.common.base.ErrorResult
import com.ddstudio.domain.utils.DEFAULT_INT
import retrofit2.HttpException
import java.net.UnknownHostException

fun Throwable.getError(): ErrorResult{
    return when(this){
        is HttpException -> {
            val bodyString = this.response()?.errorBody()?.string()?.trim()
            try{
                ErrorResult(
                    code = this.code(),
                    message = if(bodyString.isNullOrEmpty()) null else bodyString
                )
            } catch (e: Exception){
                ErrorResult(code = null)
            }
        }
        is IllegalStateException ->
            ErrorResult(code = null)
        is UnknownHostException ->
            ErrorResult(code = null)
        else -> {
            if(this.message?.safeIsInt() is Int)
                ErrorResult(code = this.message?.safeIsInt())
            else
                ErrorResult(DEFAULT_INT)
        }
    }
}