package com.joina.joinaonline.Joinaonline.EventsAndBooking;

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
import com.joina.joinaonline.Joinaonline.ListStoresActivities.EventsAndBookingListStoresActivity;
import com.joina.joinaonline.Joinaonline.adapter.Categories;
import com.joina.joinaonline.Joinaonline.adapter.CategoryAdapter;
import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.Joinaonline.adapter.ProductAdapter;
import com.joina.joinaonline.Joinaonline.StorefrontLayout;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;

public class EventsAndBookingJOActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, productRecycler;
    CategoryAdapter categoryAdapter;
    ProductAdapter productAdapter;
    TextView seeAll;


    List<Categories> productCategoryList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_and_booking_joactivity);

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
                Intent intent = new Intent(EventsAndBookingJOActivity.this, EventsAndBookingListStoresActivity.class);
                startActivity(intent);
            }
        });

        categoryRecycler = findViewById(R.id.categories_list);

        productCategoryList.add(new Categories(1, "Groceries"));
        productCategoryList.add(new Categories(2, "Technologies"));
        productCategoryList.add(new Categories(3, "Fast Food Outlets"));
        productCategoryList.add(new Categories(4, "Services"));
        productCategoryList.add(new Categories(5, "Deals"));
        productCategoryList.add(new Categories(6, "Gaming"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EventsAndBookingJOActivity.this, RecyclerView.HORIZONTAL, false);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(EventsAndBookingJOActivity.this, productCategoryList);
        categoryRecycler.setAdapter(categoryAdapter);

        productRecycler = findViewById(R.id.products_list);

        productList.add(new Product(1, "Event", "Opposite", "$ 17.00", R.drawable.add2_icon));
        productList.add(new Product(2, "Event", "First floor", "$ 25.00", R.drawable.add2_icon));
        productList.add(new Product(3, "Event", "Top floor", "$ 17.00", R.drawable.add2_icon));
        productList.add(new Product(4, "Event", "Ground floor", "$ 17.00", R.drawable.add2_icon));
        productList.add(new Product(4, "Event", "Ground floor", "$ 17.00", R.drawable.add2_icon));

//        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(EventsAndBookingJOActivity.this, RecyclerView.HORIZONTAL, false);
//        productRecycler.setLayoutManager(layoutManager2);
//        productAdapter = new ProductAdapter(EventsAndBookingJOActivity.this, productList);
//        productRecycler.setAdapter(productAdapter);

    }

    public void viewDetails(int pos) {

        Intent intent = new Intent(this, StorefrontLayout.class);
        intent.putExtra("name",productList.get(pos).getProd_name());
        intent.putExtra("floor",productList.get(pos).getPrice());
        intent.putExtra("image",productList.get(pos).getImageUrl());
        startActivity(intent);

    }}

