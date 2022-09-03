package com.book.fidibo.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.book.fidibo.models.BookMark;
import com.book.fidibo.models.Category;
import com.book.fidibo.models.Favorite;
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

    @Insert
    void insertFavorite(Favorite favorite);

    @Query("select*from tbl_shelf")
    List<Shelf> shelfList();


    @Query("select * from tbl_book")
    List<Category> categoryList();


    @Query("select shelfTitle from tbl_shelf")
    List<String>list();

    @Query("select id from tbl_shelf")
    List<Integer>listId();


    @Query("select * from tbl_book_mark")
    List<BookMark> bookMarkList();

    @Query("select * from tbl_book_mark")
    List<Category> bookMarkListSingle();



    @Query("select * from tbl_specialCategory")
    List<SpecialCategory> specialCategoryList();

    @Query("select * from tbl_favorite")
    List<Favorite> favoriteList();

    @Query("select id from tbl_favorite")
    List<Integer> listIdFavorite();



    @Update
    void update(Category category);

    @Query("SELECT EXISTS( SELECT* FROM tbl_book where id = :categoryId)")
    boolean isRowIsExist(int categoryId);


    @Query("SELECT EXISTS( SELECT* FROM tbl_book_mark where id = :bookMarkId)")
    boolean isRowIsExistBookMArk(int bookMarkId);

    @Query("SELECT EXISTS(SELECT * FROM tbl_shelf where id = :shelfId)")
    boolean isRowExistsShelf(int shelfId);

    @Query("SELECT EXISTS(SELECT * FROM tbl_favorite where id = :favoriteID)")
    boolean isRowExistsFavorite(int favoriteID);

    //Query for delete a row

    @Query("delete from tbl_book where id = :categoryId")
    void deleteVideo(int categoryId);

    @Query("delete from tbl_book_mark where id = :bookMarkId")
    void deleteBookMArk(int bookMarkId);

    @Query("delete from tbl_specialCategory where id = :listId")
     void deleteCategory(int listId);

    @Query("delete from tbl_shelf where id = :listShelf")
    void deleteShelf(int listShelf);


    @Query("delete from tbl_favorite where id = :favoriteId")
    void deleteFavorite(int favoriteId);
}
