package com.videoclub.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.videoclub.dao.MovieDao;
import com.videoclub.dao.ReservationDao;
import com.videoclub.dao.UserDao;
import com.videoclub.entity.Movie;
import com.videoclub.entity.Reservation;
import com.videoclub.entity.User;

/**
 * Created by Kostas on 1/10/2018.
 */

@Database(entities = {User.class, Movie.class, Reservation.class}, version = 4)
public abstract class VideoClubDatabase extends RoomDatabase{

    private static VideoClubDatabase INSTANCE;

    public abstract UserDao userDao();
    public abstract ReservationDao reservationDao();
    public abstract MovieDao movieDao();

    public static VideoClubDatabase getVideoClubDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), VideoClubDatabase.class, "video-club-database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
