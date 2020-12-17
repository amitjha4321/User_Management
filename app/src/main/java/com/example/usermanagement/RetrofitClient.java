package com.example.usermanagement;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitClient{




    public static String BASE_URL="http://192.168.1.66:8081/";
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;


    public RetrofitClient(){

            retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


    }
    //
    public static synchronized RetrofitClient getInstance(){
        if (retrofitClient==null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public ApiInterface getApi(){
        return retrofit.create(ApiInterface.class);
    }


}