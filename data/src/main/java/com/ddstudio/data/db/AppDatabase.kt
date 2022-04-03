package com.ddstudio.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ddstudio.data.db.dao.MovieDao
import com.ddstudio.data.db.entities.MovieDb

@Database(entities = [MovieDb::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}