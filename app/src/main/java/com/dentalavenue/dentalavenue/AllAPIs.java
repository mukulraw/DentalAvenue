package com.dentalavenue.dentalavenue;

import com.dentalavenue.dentalavenue.RegisterPOJO.registerBean;
import com.dentalavenue.dentalavenue.banner.bannerbean;
import com.dentalavenue.dentalavenue.categoryPOJO.categoryBean;
import com.dentalavenue.dentalavenue.cityPOJO.cityBean;
import com.dentalavenue.dentalavenue.countryPOJO.countryBean;
import com.dentalavenue.dentalavenue.loginPOJO.loginBean;
import com.dentalavenue.dentalavenue.statePOJO.stateBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AllAPIs {

    @Multipart
    @POST("dental_avenue/app-api/register_doctor.php")
    Call<registerBean> registerDoctor(@Part("fname") String fName, @Part("lname") String lName , @Part("email") String email , @Part("phone") String phone , @Part("password") String password , @Part("type") String type , @Part("registration_no") String regNo);

    @Multipart
    @POST("dental_avenue/app-api/register_dealer.php")
    Call<registerBean> registerSalesPerson(@Part("fname") String fName, @Part("lname") String lName , @Part("email") String email , @Part("phone") String phone , @Part("password") String password , @Part("type") String type , @Part("company") String company , @Part("cin_no") String cinNo , @Part("vat_no") String vatNo , @Part("country") String country , @Part("state") String state , @Part("city") String city , @Part("pincode") String pinCode , @Part("address") String address , @Part("address2") String address2);

    @Multipart
    @POST("dental_avenue/app-api/login.php")
    Call<loginBean> login(@Part("email") String email , @Part("password") String password , @Part("type") String type);

    @Multipart
    @POST("dental_avenue/app-api/category.php")
    Call<categoryBean> category(@Part("pid") String pid);

    @GET("dental_avenue/app-api/banner.php")
    Call<bannerbean> getBanner();

    @GET("dental_avenue/app-api/country.php")
    Call<countryBean> getCountries();

    @Multipart
    @POST("dental_avenue/app-api/state.php")
    Call<stateBean> getState(@Part("country_id") String countryId);

    @Multipart
    @POST("dental_avenue/app-api/city.php")
    Call<cityBean> getCity(@Part("state_id") String countryId);
}
