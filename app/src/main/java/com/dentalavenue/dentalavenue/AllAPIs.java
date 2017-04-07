package com.dentalavenue.dentalavenue;

import com.dentalavenue.dentalavenue.RegisterPOJO.registerBean;
import com.dentalavenue.dentalavenue.categoryPOJO.categoryBean;
import com.dentalavenue.dentalavenue.loginPOJO.loginBean;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AllAPIs {

    @Multipart
    @POST("dental_avenue/app-api/register.php")
    Call<registerBean> register(@Part("fname") String fName, @Part("lname") String lName , @Part("email") String email , @Part("phone") String phone , @Part("password") String password , @Part("type") String type);

    @Multipart
    @POST("dental_avenue/app-api/login.php")
    Call<loginBean> login(@Part("email") String email , @Part("password") String password , @Part("type") String type);

    @Multipart
    @POST("dental_avenue/app-api/category.php")
    Call<categoryBean> category(@Part("pid") String pid);

}
