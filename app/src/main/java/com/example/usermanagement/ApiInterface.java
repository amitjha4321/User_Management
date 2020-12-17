package com.example.usermanagement;

import com.example.usermanagement.ModelResponse.RegisterResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("/register")
    Call<RegisterResponse> registeruser(
            @Field("userName") String username,
            @Field("emailId") String emailid,
            @Field("password") String password
//            @Part MultipartBody.Part image
//
           );
//    @Headers("Content-Type: application/json")
//    @POST("/register")
//    Call<RegisterResponse> registerUser(@Body RegisterResponse registerResponse);

//    @POST("/userprofileimageupload")
//    Call<RegisterResponse> uploadOnly(@Part MultipartBody.Part image);


}
