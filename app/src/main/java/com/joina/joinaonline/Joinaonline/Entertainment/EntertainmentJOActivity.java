package com.joina.joinaonline.Joinaonline.Entertainment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.EntertainmentListStoresActivity;
import com.joina.joinaonline.Joinaonline.adapter.Categories;
import com.joina.joinaonline.Joinaonline.adapter.CategoryAdapter;
import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.Joinaonline.adapter.ProductAdapter;
import com.joina.joinaonline.Joinaonline.StorefrontLayout;
import com.joina.joinaonline.Joinaonline.adapter.VendorAdapter;
import com.joina.joinaonline.Joinaonline.adapter.VendorResponse;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;

public class EntertainmentJOActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, vendorRecycler;
    CategoryAdapter categoryAdapter;
    VendorAdapter vendorAdapter;
    TextView seeAll;

    List<Categories> productCategoryList = new ArrayList<>();
    List<VendorResponse> vendorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment_joactivity);

        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        List<SlideModel> slideModelList = new ArrayList<>();
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/special-offer-final-sale-banner-600w-1387497926.jpg","PSMAS Promotion",ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/99-shopping-day-poster-banner-600w-2024061551.jpg", "Valentines Promotion", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Hello Promo", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "Terrific Tuesday", ScaleTypes.FIT));

        imageSlider.setImageList(slideModelList);

        seeAll = findViewById(R.id.seeAll);
        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EntertainmentJOActivity.this, EntertainmentListStoresActivity.class);
                startActivity(intent);
            }
        });

        categoryRecycler = findViewById(R.id.categories_list);

        productCategoryList.add(new Categories(1, "Movies1"));
        productCategoryList.add(new Categories(2, "Movies2"));
        productCategoryList.add(new Categories(3, "Movies3"));
        productCategoryList.add(new Categories(4, "Movies4"));
        productCategoryList.add(new Categories(5, "Movies5"));
        productCategoryList.add(new Categories(6, "Movies6"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EntertainmentJOActivity.this, RecyclerView.HORIZONTAL, false);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(EntertainmentJOActivity.this, productCategoryList);
        categoryRecycler.setAdapter(categoryAdapter);

        vendorRecycler = findViewById(R.id.products_list);

        vendorList.add(new VendorResponse(1, "A", "Opposite", R.drawable.add2_icon));
        vendorList.add(new VendorResponse(2, "B", "First floor",  R.drawable.add2_icon));
        vendorList.add(new VendorResponse(3, "C", "Top floor",  R.drawable.add2_icon));
        vendorList.add(new VendorResponse(4, "D", "Ground floor",  R.drawable.add2_icon));
        vendorList.add(new VendorResponse(4, "E", "Ground floor", R.drawable.add2_icon));

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(EntertainmentJOActivity.this, RecyclerView.HORIZONTAL, false);
        vendorRecycler.setLayoutManager(layoutManager2);
        vendorAdapter = new VendorAdapter(EntertainmentJOActivity.this, vendorList);
        vendorRecycler.setAdapter(vendorAdapter);

    }

    public void viewDetails(int pos) {

        Intent intent = new Intent(this, StorefrontLayout.class);
        intent.putExtra("name",vendorList.get(pos).getProd_name());
        intent.putExtra("floor",vendorList.get(pos).getPrice());
        intent.putExtra("image",vendorList.get(pos).getImageUrl());
        startActivity(intent);

    }}