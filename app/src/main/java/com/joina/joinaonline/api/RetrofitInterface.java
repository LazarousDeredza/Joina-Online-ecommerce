package com.joina.joinaonline.api;

import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.SmartParking.Admin.Models.TagManagementModel;
import com.joina.joinaonline.SmartParking.Admin.ParkingLog.ParkingLogModel;
import com.joina.joinaonline.model.Category;

import com.joina.joinaonline.model.Brand;
import com.joina.joinaonline.model.Discount;
import com.joina.joinaonline.model.DiscountDto;
import com.joina.joinaonline.model.Login;
import com.joina.joinaonline.model.ProductDto;
import com.joina.joinaonline.model.Promotion;
import com.joina.joinaonline.model.SubCategory;
import com.joina.joinaonline.model.Tax;
import com.joina.joinaonline.model.TaxDto;
import com.joina.joinaonline.model.Tokens;
import com.joina.joinaonline.model.Vendor;


import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface RetrofitInterface {

    @Multipart
    @POST("uploads/products")
    Call<List<String>> uploadImage(@Part MultipartBody.Part[] files);

    @POST("subcategories")
    Call<String> createSubCategory(@Body SubCategory subCategory);

    @Multipart
    @POST("uploads/brand")
    Call<String> uploadbrand( @Part  MultipartBody.Part file);

    @POST("tax/save")
    Call<String> saveTax(@Body TaxDto taxDto);

    @GET("brands")
    Call<List<Brand>> getBrands();

    @GET("tax")
    Call<List<Tax>> getTaxes();

    @GET("tax/vendor/{id}")
    Call<List<Tax>> getVendorTaxes(@Path("id")Long id);

    @POST("discount")
    Call<String> saveDiscount(@Body DiscountDto discountDto);

    @GET("discount/vendor/{id}")
    Call<List<Discount>> getVendorDiscount(@Path("id") Long id);

    @POST("categories")
    Call<String>createCategory(@Body Category category);

    @GET("categories")
    Call<List<Category>> getCategory();

    //**********************************************
    @GET("products")
    Call<List<ProductDto>> getProducts();
    //**********************************************

    @POST("subcategories")
    Call<String>saveSubcategory(@Body SubCategory subcategory);

    @POST("brands")
    Call<String>saveBrands(@Body Brand brand);

    @GET("categories")
    Call<List<Category>> getCategories();

//    @GET("products")
//    Call<List<ProductDto>> getProducts();

    @GET("subcategories")
    Call<List<SubCategory>> getSubCategories();

    @GET("promotions/vendor/{id}")
    Call<List<Promotion>> getVendorPromotion(@Path("id") Long id);


    @POST("products/save")
    Call<String> saveProduct(@Body ProductDto productDto);

    @POST("signin/{email}{password}")
    Call<Tokens> login(@Path("email") String email , @Path("password")String password);

    @POST("vendors")
    Call<String> addVendor(@Body Vendor vendors);

    //parking
    @GET("parking/all")
    Call<ArrayList<ParkingLogModel>> getParkingLogViewModel();


    @GET("parking-card/all")
    Call<ArrayList<TagManagementModel>> getTagManagementViewModel();























    //    @POST("login/{email}{password}")
//    Call<Tokens> login(@Path("email") String email , @Path("password")String password);

//    @POST("signin")
//    Call<Tokens> login(@Body Login login);

    //@POST("/api/login")
    // Call<LoginResponse> login(@Body LoginBody loginBody);

}



//    java.lang.NumberFormatException: For input string: "http://165.22.126.3:4100/media/products/close1.jpg"
//            at java.lang.Integer.parseInt(Integer.java:615)
//            at java.lang.Integer.parseInt(Integer.java:650)
//            at com.joina.joinaonline.ProductAdapter2.onBindViewHolder(ProductAdapter2.java:51)
//            at com.joina.joinaonline.ProductAdapter2.onBindViewHolder(ProductAdapter2.java:25)