package com.book.fidibo.webServise;

import com.book.fidibo.models.BookModel;
import com.book.fidibo.models.CategoryModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IService {


    @GET("api.php?latest")
    Call<BookModel> getListBook();

    @GET("api.php")
    Call<CategoryModel> getBookByCategory(@Query("cat_id") int id);

    @GET("api.php?search_text=")
    Call<CategoryModel> getSearchBook();




}
