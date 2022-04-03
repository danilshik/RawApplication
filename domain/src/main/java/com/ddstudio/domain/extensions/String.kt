package com.ddstudio.domain.extensions

import com.ddstudio.domain.utils.EMPTY

fun String?.safeIsInt() : Int? {
    return if(this == EMPTY || this?.isInt() == false) null
    else this?.toInt()
}

fun String.isInt(): Boolean {
    return try {
        this.toInt() is Int
    } catch (e: Exception) {
        false
    }
}