package com.ddstudio.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ddstudio.data.db.entities.MovieDb

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getAll() : List<MovieDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies : List<MovieDb>)
}