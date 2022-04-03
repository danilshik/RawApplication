package com.ddstudio.domain.common.base

data class ErrorResult(
    val code :Int? = null,
    val message: String? = null,
    val throwable: Throwable? = null
)