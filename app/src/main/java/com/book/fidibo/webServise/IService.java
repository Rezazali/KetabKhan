package com.book.fidibo.webServise;

import androidx.annotation.Nullable;

import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.models.objectModel.SpecialCategoryModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IService {


    @Nullable
    @GET("api.php?latest")
    Call<CategoryModel> getListBook();

    @Nullable
    @GET("api.php")
    Call<CategoryModel> getBookByCategory(@Query("cat_id") int id);


    @Nullable
    @GET("api.php")
    Call<SpecialCategoryModel> getBookByCategorySpecial(@Query("cat_id") int id);

    @Nullable
    @GET("api.php?search_text=")
    Call<CategoryModel> getSearchBook();




}
