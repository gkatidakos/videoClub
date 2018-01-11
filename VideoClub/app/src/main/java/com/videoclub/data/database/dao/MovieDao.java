package com.videoclub.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.videoclub.data.database.entity.Movie;

import java.util.List;

/**
 * Created by Kostas on 1/10/2018.
 */

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie")
    List<Movie> getAllMovies();

    @Insert
    void insertMovie(Movie movie);

    @Insert
    void insertAllMovies(List<Movie> movies);

    @Delete
    void deleteMovie(Movie movie);

    @Query("DELETE FROM movie")
    void deleteAll();
}