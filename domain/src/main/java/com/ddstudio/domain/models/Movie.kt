package com.ddstudio.domain.models

import com.ddstudio.domain.models.base.BaseModel

data class Movie(
    val id: String? = null,
    val poster: String? = null,
    val year: String? = null
) : BaseModel