package com.dentalavenue.dentalavenue;

import com.dentalavenue.dentalavenue.AddRatingPOJO.AddRatingBean;
import com.dentalavenue.dentalavenue.OfferPOJO.OfferBeann;
import com.dentalavenue.dentalavenue.addCartPOJO.addCartBean;
import com.dentalavenue.dentalavenue.addWishlistPOJO.addWishlistBean;
import com.dentalavenue.dentalavenue.banner.bannerbean;
import com.dentalavenue.dentalavenue.categoryPOJO.categoryBean;
import com.dentalavenue.dentalavenue.changePassPOJO.ChangePass;
import com.dentalavenue.dentalavenue.changePassPOJO.PassChange;
import com.dentalavenue.dentalavenue.cityPOJO.cityBean;
import com.dentalavenue.dentalavenue.countryPOJO.countryBean;
import com.dentalavenue.dentalavenue.loginPOJO.loginBean;
import com.dentalavenue.dentalavenue.productPOJO.productbean;
import com.dentalavenue.dentalavenue.registerDealerPOJO.registerDealerBean;
import com.dentalavenue.dentalavenue.registerDoctorPOJO.registerDoctorBean;
import com.dentalavenue.dentalavenue.singleProductPOJO.singleProductBean;
import com.dentalavenue.dentalavenue.statePOJO.stateBean;
import com.dentalavenue.dentalavenue.viewCartPOJO.viewCartBean;
import com.dentalavenue.dentalavenue.viewRatingPOJO.viewRatingBean;
import com.dentalavenue.dentalavenue.viewWishlistPOJO.WishlishtDetailsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AllAPIs {

    @Multipart
    @POST("dental_avenue/app-api/register_doctor.php")
    Call<registerDoctorBean> registerDoctor(@Part("fname") String fName, @Part("lname") String lName , @Part("email") String email , @Part("phone") String phone , @Part("password") String password , @Part("type") String type , @Part("registration_no") String regNo);

    @Multipart
    @POST("dental_avenue/app-api/register_dealer.php")
    Call<registerDealerBean> registerSalesPerson(@Part("fname") String fName, @Part("lname") String lName , @Part("email") String email , @Part("phone") String phone , @Part("password") String password , @Part("type") String type , @Part("company") String company , @Part("cin_no") String cinNo , @Part("vat_no") String vatNo , @Part("country") String country , @Part("state") String state , @Part("city") String city , @Part("pincode") String pinCode , @Part("address") String address , @Part("address2") String address2);

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

    @Multipart
    @POST("dental_avenue/app-api/productbycatid.php")
    Call<productbean> getProducts(@Part("cat_id") String cat_id);

    @GET("dental_avenue/app-api/offer.php")
    Call<OfferBeann> getCOffers();

    @Multipart
    @POST("dental_avenue/app-api/search.php")
    Call<productbean> search(@Part("keyword") String keyWord);

    @Multipart
    @POST("dental_avenue/app-api/productbyid.php")
    Call<singleProductBean> getProductDetails(@Part("pid") String pId);

    @Multipart
    @POST("dental_avenue/app-api/add-to-cart.php")
    Call<addCartBean> addToCart(@Part("user_id") String userId , @Part("product_id") String productId , @Part("size") String Size , @Part("sku") String SKU , @Part("price") String Price , @Part("sale_price") String salePrice , @Part("offer_doctor") String offerDoctor , @Part("offer_dealer") String offerDealer , @Part("qty") String Qty , @Part("user_type") String userType);

    @Multipart
    @POST("dental_avenue/app-api/add_whishlist.php")
    Call<addWishlistBean> addWishlist(@Part("userid") String userId , @Part("pid") String pId);

    @Multipart
    @POST("dental_avenue/app-api/cart_data.php")
    Call<viewCartBean> viewCart(@Part("userid") String userId);

    @Multipart
    @POST("dental_avenue/app-api/view_rating.php")
    Call<viewRatingBean> viewRating(@Part("proid") String proId);


    @Multipart
    @POST("dental_avenue/app-api/password_change.php")
    Call<ChangePass> changePass(@Part("old_pass") String oldPass, @Part("new_pass") String newPass, @Part("userid") String userId);


    @Multipart
    @POST("dental_avenue/app-api/wishlist_detail.php")
    Call<WishlishtDetailsBean> wishlist_details(@Part("userid") String userId);

    @Multipart
    @POST("dental_avenue/app-api/add_rating.php")
    Call<AddRatingBean> Add_rating(@Part("userid") String userId, @Part("proid") String proId, @Part("comment") String comment, @Part("rate") String rate);


}
