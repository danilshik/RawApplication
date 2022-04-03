package com.ddstudio.domain.common.base

sealed class BaseResult <out T: Any>{
    data class Loading<T : Any>(val data: T? = null): BaseResult<T>()
    data class Success<T : Any>(val data: T): BaseResult<T>()
    data class Error(val data: ErrorResult): BaseResult<Nothing>()
    object Empty: BaseResult<Nothing>()



}