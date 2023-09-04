package com.joina.joinaonline.Joinaonline.FoodandDrink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.joina.joinaonline.Joinaonline.Interfaces.LogoInterface;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.FoodAndDrinkListStoresActivity;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.MedicalListStoresActivity;
import com.joina.joinaonline.Joinaonline.Medical.MedicalJOActivity;
import com.joina.joinaonline.Joinaonline.StorefrontLayout;
import com.joina.joinaonline.Joinaonline.adapter.Categories;
import com.joina.joinaonline.Joinaonline.adapter.CategoryAdapter;
import com.joina.joinaonline.Joinaonline.adapter.Logo;
import com.joina.joinaonline.Joinaonline.adapter.LogoAdapter;
import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.Joinaonline.adapter.ProductAdapter;
import com.joina.joinaonline.Joinaonline.adapter.VendorAdapter;
import com.joina.joinaonline.Joinaonline.adapter.VendorResponse;
import com.joina.joinaonline.R;
import com.joina.joinaonline.SmartParking.Admin.Interfaces.UsersInterface;

import java.util.ArrayList;
import java.util.List;

public class FoodandDrinkJOActivity extends AppCompatActivity implements LogoInterface {

    RecyclerView categoryRecycler, vendorRecycler, logoRecycler, productsRecycler;
    CategoryAdapter categoryAdapter;
    VendorAdapter vendorAdapter;
    ProductAdapter productAdapter;
    LogoAdapter logoAdapter;
    List<Logo> logoList = new ArrayList<>();
    TextView seeAll;
    ImageSlider imageSlider;

    List<Categories> productCategoryList = new ArrayList<>();
    List<VendorResponse> vendorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodand_drink_joactivity);

        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        List<SlideModel> slideModelList = new ArrayList<>();
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/special-offer-final-sale-banner-600w-1387497926.jpg","PSMAS Promotion", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/99-shopping-day-poster-banner-600w-2024061551.jpg", "Valentines Promotion", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Hello Promo", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "Terrific Tuesday", ScaleTypes.FIT));

        imageSlider.setImageList(slideModelList);


        seeAll = findViewById(R.id.seeAll);
        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodandDrinkJOActivity.this, FoodAndDrinkListStoresActivity.class);
                startActivity(intent);
            }
        });

        logoRecycler = findViewById(R.id.logo_recycler);

        logoList.add(new Logo(R.drawable.chicken_hut, "chicken_hut"));
        logoList.add(new Logo(R.drawable.pizza_hut, "pizza_hut"));
        logoList.add(new Logo(R.drawable.kfc, "kfc"));
        logoList.add(new Logo(R.drawable.helens_cakes, "helens_cakes"));
        logoList.add(new Logo(R.drawable.barcelos, "barcelos"));
        logoList.add(new Logo(R.drawable.sandy, "sandy"));
        logoList.add(new Logo(R.drawable.yanaya, "yanaya"));
        logoList.add(new Logo(R.drawable.chicken_hut, "8"));
        logoList.add(new Logo(R.drawable.pizza_hut, "9"));
        logoList.add(new Logo(R.drawable.kfc, "10"));
        logoList.add(new Logo(R.drawable.helens_cakes, "11"));
        logoList.add(new Logo(R.drawable.barcelos, "12"));
        logoList.add(new Logo(R.drawable.sandy, "13"));
        logoList.add(new Logo(R.drawable.yanaya, "14"));


        RecyclerView.LayoutManager layoutManagerLogo = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        logoRecycler.setLayoutManager(layoutManagerLogo);
        logoAdapter = new LogoAdapter((Context) FoodandDrinkJOActivity.this, logoList, this);
        logoRecycler.setAdapter(logoAdapter);

        productsRecycler = findViewById(R.id.products_list);
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Proton Bread","brand", "ZWL 90", R.drawable.bread));
        productList.add(new Product(1, "Proton Bread","brand", "ZWL 90", R.drawable.potatoes));
        productList.add(new Product(1, "Proton Bread","brand", "ZWL 90", R.drawable.sugar));
        productList.add(new Product(1, "Proton Bread","brand", "ZWL 90", R.drawable.spuds));
        productList.add(new Product(1, "Proton Bread","brand", "ZWL 90", R.drawable.knorrox));
        productList.add(new Product(1, "Proton Bread","brand", "ZWL 90", R.drawable.bread));

//        RecyclerView.LayoutManager layoutManagerProduct = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
//        productsRecycler.setLayoutManager(layoutManagerProduct);
//        productAdapter = new ProductAdapter(FoodandDrinkJOActivity.this, productList);
//        productsRecycler.setAdapter(productAdapter);


        categoryRecycler = findViewById(R.id.categories_list);
        productCategoryList.add(new Categories(1, "Groceries"));
        productCategoryList.add(new Categories(2, "Technologies"));
        productCategoryList.add(new Categories(3, "Fast Food Outlets"));
        productCategoryList.add(new Categories(4, "Services"));
        productCategoryList.add(new Categories(5, "Deals"));
        productCategoryList.add(new Categories(6, "Gaming"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FoodandDrinkJOActivity.this, RecyclerView.HORIZONTAL, false);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(FoodandDrinkJOActivity.this, productCategoryList);
        categoryRecycler.setAdapter(categoryAdapter);


        vendorRecycler = findViewById(R.id.vendor_list);

        vendorList.add(new VendorResponse(1, "KFC", "Opposite",  R.drawable.kfc));
        vendorList.add(new VendorResponse(2, "Pizza-hut", "First floor", R.drawable.pizza_hut));
        vendorList.add(new VendorResponse(3, "Barcelos", "Top floor", R.drawable.barcelos));
        vendorList.add(new VendorResponse(4, "Helen's Cakes", "Ground floor", R.drawable.helens_cakes));

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(FoodandDrinkJOActivity.this, RecyclerView.HORIZONTAL, false);
        vendorRecycler.setLayoutManager(layoutManager2);
        vendorAdapter = new VendorAdapter(FoodandDrinkJOActivity.this, vendorList);
        vendorRecycler.setAdapter(vendorAdapter);
    }

    public void viewDetails(int pos) {

        Intent intent = new Intent(this, StorefrontLayout.class);
        intent.putExtra("name",vendorList.get(pos).getProd_name());
        intent.putExtra("floor",vendorList.get(pos).getPrice());
        intent.putExtra("image",vendorList.get(pos).getImageUrl());
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onItemClick(int position, View view) {
        int imageUrl = logoList.get(position).getImageUrl();
        String name = logoList.get(position).getName();

//        navController = Navigation.findNavController(view);
        if (name != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("imageUrl", imageUrl);
            bundle.putString("name", name);

//            navController.navigate(R.id.action_SPUsersFragment_to_userDetailsFragment, bundle);

        }
    }
}