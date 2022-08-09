package com.book.fidibo.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.book.fidibo.models.Category;
import com.book.fidibo.models.SpecialCategory;

import java.util.List;

@Dao
public interface IDAO {

    @Insert
    long insert (Category category);

    @Insert
    void insertList (List<SpecialCategory> specialCategoryList);


    @Query("select * from tbl_book")
    List<Category> categoryList();


    @Query("select * from tbl_specialCategory")
    List<SpecialCategory> specialCategoryList();


    @Update
    void update(Category category);

    @Query("SELECT EXISTS( SELECT* FROM tbl_book where id = :categoryId)")
    boolean isRowIsExist(int categoryId);


    @Query("delete from tbl_book where id = :categoryId")
    void deleteVideo(int categoryId);

    @Query("delete from tbl_specialCategory where id = :listId")
     void deleteCategory(int listId);



}
