package com.book.fidibo.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.book.fidibo.models.BookMark;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.Shelf;
import com.book.fidibo.models.SpecialCategory;

import java.util.List;

@Dao
public interface IDAO {

    @Insert
    long insert (Category category);

    @Insert
    void insertList (List<SpecialCategory> specialCategoryList);

    @Insert
    long insertBookMArk (BookMark bookMark);

    @Insert
    long insertShelf(Shelf shelf);


    @Query("select * from tbl_book")
    List<Category> categoryList();


    @Query("select * from tbl_book_mark")
    List<BookMark> bookMarkList();



    @Query("select * from tbl_specialCategory")
    List<SpecialCategory> specialCategoryList();


    @Update
    void update(Category category);

    @Query("SELECT EXISTS( SELECT* FROM tbl_book where id = :categoryId)")
    boolean isRowIsExist(int categoryId);


    @Query("SELECT EXISTS( SELECT* FROM tbl_book_mark where id = :bookMarkId)")
    boolean isRowIsExistBookMArk(int bookMarkId);

    @Query("SELECT EXISTS(SELECT * FROM tbl_shelf where id = :shelfId)")
    boolean isRowExistsShelf(int shelfId);


    @Query("delete from tbl_book where id = :categoryId")
    void deleteVideo(int categoryId);

    @Query("delete from tbl_book_mark where id = :bookMarkId")
    void deleteBookMArk(int bookMarkId);

    @Query("delete from tbl_specialCategory where id = :listId")
     void deleteCategory(int listId);



}
