package com.book.fidibo.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.book.fidibo.models.Category;

import java.util.List;

@Dao
public interface IDAO {

    @Insert
    long insert (Category category);

    @Query("select * from tbl_book")
    List<Category> categoryList();

    @Update
    void update(Category category);

    @Query("SELECT EXISTS(SELECT * FROM tbl_book where id = :categoryId)")
    boolean isRowIsExist(int categoryId);


    @Query("delete from tbl_book where id = :categoryId")
    void deleteVideo(int categoryId);


}
