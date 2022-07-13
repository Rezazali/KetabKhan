package com.book.fidibo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.book.fidibo.models.Category;

@Database(entities = {Category.class}, version = 1,exportSchema = false )
public abstract class AppDatabase extends RoomDatabase {


    public static String DB_NAME = "category.db";

    public static volatile AppDatabase instance;

    public abstract IDAO idao();

    public static AppDatabase getInstance(Context context){
        if (instance == null){
            synchronized (AppDatabase.class){
                if (instance == null){
                    instance = Room.databaseBuilder(context,AppDatabase.class,DB_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }

}
