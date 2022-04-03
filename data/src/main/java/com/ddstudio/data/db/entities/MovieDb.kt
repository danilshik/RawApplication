package com.ddstudio.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ddstudio.data.db.BaseEntity

@Entity(tableName = "movie")
data class MovieDb(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "poster")
    val poster: String? = null,
    @ColumnInfo(name = "year")
    val year: String? = null
) : BaseEntity