package com.book.fidibo.ui;

import androidx.annotation.NonNull;

import com.book.fidibo.models.BookModel;
import com.book.fidibo.models.CategoryModel;
import com.book.fidibo.webServise.ApiUtils;
import com.book.fidibo.webServise.IService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServiceCaller {


    IService iService;

    public WebServiceCaller(){
         iService = ApiUtils.getRetrofit().create(IService.class);
    }

   public void getListBook(IResponseListener listener){
        iService.getListBook().enqueue(new Callback<BookModel>() {
            @Override
            public void onResponse(@NonNull Call<BookModel> call, @NonNull Response<BookModel> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<BookModel> call, @NonNull Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });

   }

   public void getBookByCategory(IResponseListener listener, int id){

       iService.getBookByCategory(id).enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(@NonNull Call<CategoryModel> call, @NonNull Response<CategoryModel> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<CategoryModel> call, @NonNull Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
   }

   public void getSearchBook(IResponseListener listener){
        iService.getSearchBook().enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(@NonNull Call<CategoryModel> call, @NonNull Response<CategoryModel> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<CategoryModel> call, @NonNull Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
   }


}
