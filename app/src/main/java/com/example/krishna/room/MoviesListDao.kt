package com.example.krishna.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.krishna.model.SearchItem

@Dao
interface MoviesListDao {
    @Insert
    fun insertAllMoviesList(vararg movie: SearchItem)

    @Delete
    fun deleTeMoviesLis( movie: SearchItem)
}