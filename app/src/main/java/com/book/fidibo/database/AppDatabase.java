package com.book.fidibo.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.book.fidibo.models.BookMark;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.Favorite;
import com.book.fidibo.models.Shelf;
import com.book.fidibo.models.SpecialCategory;

@Database(entities = {Category.class, SpecialCategory.class, BookMark.class, Shelf.class, Favorite.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {


    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
        }
    };


    public static String DB_NAME = "category.db";

    public static volatile AppDatabase instance;

    public abstract IDAO idao();

    public static AppDatabase getInstance(Context context){
        if (instance == null){
            synchronized (AppDatabase.class){
                if (instance == null){
                    instance = Room.databaseBuilder(context,AppDatabase.class,DB_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .addMigrations(MIGRATION_1_2)
                            .build();
                }
            }
        }
        return instance;
    }

}
