package com.book.fidibo.webServise;

import com.book.fidibo.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {


     public static volatile Retrofit retrofit = null;

    private ApiUtils(){

    }

    public static Retrofit getRetrofit(){

        if (retrofit == null){
            synchronized (ApiUtils.class){
                if (retrofit ==null){
                    retrofit = new Retrofit.Builder()
                            .baseUrl(Constants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
