package com.ddstudio.data.remote.dto

import com.ddstudio.data.remote.dto.base.BaseResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "poster")
    val poster: String? = null,
    @Json(name = "year")
    val year: String? = null
) : BaseResponse