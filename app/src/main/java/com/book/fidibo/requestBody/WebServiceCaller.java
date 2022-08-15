package com.book.fidibo.requestBody;

import androidx.annotation.NonNull;

import com.book.fidibo.models.objectModel.CategoryModel;
import com.book.fidibo.models.objectModel.SpecialCategoryModel;
import com.book.fidibo.webServise.ApiUtils;
import com.book.fidibo.webServise.IService;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServiceCaller {


    IService iService;

    public WebServiceCaller(){
         iService = ApiUtils.getRetrofit().create(IService.class);
    }

   public void getListBook(IResponseListener listener){


        Objects.requireNonNull(iService.getListBook()).enqueue(new Callback<>() {
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

   public void getBookByCategory(IResponseListener listener, int id){

       Objects.requireNonNull(iService.getBookByCategory(id)).enqueue(new Callback<>() {
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
        Objects.requireNonNull(iService.getSearchBook()).enqueue(new Callback<>() {
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

    public void getBookByCategorySpecial(IResponseListener listener, int id){

        Objects.requireNonNull(iService.getBookByCategorySpecial(id)).enqueue(new Callback<SpecialCategoryModel>() {
            @Override
            public void onResponse(@NonNull Call<SpecialCategoryModel> call, @NonNull Response<SpecialCategoryModel> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<SpecialCategoryModel> call, @NonNull Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
    }

}
