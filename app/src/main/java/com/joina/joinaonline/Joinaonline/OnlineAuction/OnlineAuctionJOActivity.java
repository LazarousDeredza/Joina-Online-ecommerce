package com.joina.joinaonline.Joinaonline.OnlineAuction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.joina.joinaonline.Joinaonline.Interfaces.LogoInterface;
import com.joina.joinaonline.Joinaonline.Medical.MedicalJOActivity;
import com.joina.joinaonline.Joinaonline.StorefrontLayout;
import com.joina.joinaonline.Joinaonline.adapter.Categories;
import com.joina.joinaonline.Joinaonline.adapter.CategoryAdapter;
import com.joina.joinaonline.Joinaonline.adapter.Logo;
import com.joina.joinaonline.Joinaonline.adapter.LogoAdapter;
import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.Joinaonline.adapter.ProductAdapter;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.OnlineAuctionListStoresActivity;
import com.joina.joinaonline.Joinaonline.adapter.VendorAdapter;
import com.joina.joinaonline.Joinaonline.adapter.VendorResponse;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;

public class OnlineAuctionJOActivity extends AppCompatActivity implements LogoInterface {

    RecyclerView categoryRecycler, vendorRecycler, logoRecycler, productsRecycler;
    CategoryAdapter categoryAdapter;
    VendorAdapter vendorAdapter;
    List<Logo> logoList = new ArrayList<>();
    LogoAdapter logoAdapter;
    ProductAdapter productAdapter;
    TextView seeAll;

    List<Categories> productCategoryList = new ArrayList<>();
    List<VendorResponse> vendorList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_auction_joactivity);

        seeAll = findViewById(R.id.seeAll);
        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnlineAuctionJOActivity.this, OnlineAuctionListStoresActivity.class);
                startActivity(intent);
            }
        });

        logoRecycler = findViewById(R.id.logo_recycler);

        logoList.add(new Logo(R.drawable.hillcrest, "hillcrest" ));
        logoList.add(new Logo(R.drawable.sandy, "sandy"));
        logoList.add(new Logo(R.drawable.lancet, "lancet"));
        logoList.add(new Logo(R.drawable.psmas, "psmas"));
        logoList.add(new Logo(R.drawable.hillcrest, "5" ));
        logoList.add(new Logo(R.drawable.sandy, "6"));
        logoList.add(new Logo(R.drawable.lancet, "7"));
        logoList.add(new Logo(R.drawable.psmas, "8"));

        RecyclerView.LayoutManager layoutManagerLogo = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        logoRecycler.setLayoutManager(layoutManagerLogo);
        logoAdapter = new LogoAdapter(OnlineAuctionJOActivity.this, logoList, this);
        logoRecycler.setAdapter(logoAdapter);

        productsRecycler = findViewById(R.id.products_list);
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Proton Bread","brand", "ZWL 90", R.drawable.bread));
        productList.add(new Product(2, "Proton Bread","brand", "ZWL 90", R.drawable.potatoes));
        productList.add(new Product(3, "Proton Bread","brand", "ZWL 90", R.drawable.sugar));
        productList.add(new Product(4, "Proton Bread","brand", "ZWL 90", R.drawable.spuds));
        productList.add(new Product(5, "Proton Bread","brand", "ZWL 90", R.drawable.knorrox));
        productList.add(new Product(6, "Proton Bread","brand", "ZWL 90", R.drawable.bread));

//        RecyclerView.LayoutManager layoutManagerProduct = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
//        productsRecycler.setLayoutManager(layoutManagerProduct);
//        productAdapter = new ProductAdapter(OnlineAuctionJOActivity.this, productList);
//        productsRecycler.setAdapter(productAdapter);

        categoryRecycler = findViewById(R.id.categories_list);
        List<Categories> productCategoryList = new ArrayList<>();
        productCategoryList.add(new Categories(1, "Groceries"));
        productCategoryList.add(new Categories(2, "Technologies"));
        productCategoryList.add(new Categories(3, "Fast Food Outlets"));
        productCategoryList.add(new Categories(4, "Services"));
        productCategoryList.add(new Categories(5, "Deals"));
        productCategoryList.add(new Categories(6, "Gaming"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(OnlineAuctionJOActivity.this, RecyclerView.HORIZONTAL, false);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(OnlineAuctionJOActivity.this, productCategoryList);
        categoryRecycler.setAdapter(categoryAdapter);

        vendorRecycler = findViewById(R.id.products_list);

        vendorList.add(new VendorResponse(1, "A", "Opposite", R.drawable.add2_icon));
        vendorList.add(new VendorResponse(2, "B", "First floor", R.drawable.add2_icon));
        vendorList.add(new VendorResponse(3, "C", "Top floor", R.drawable.add2_icon));
        vendorList.add(new VendorResponse(4, "D", "Ground floor", R.drawable.add2_icon));
        vendorList.add(new VendorResponse(5,  "E", "Ground floor", R.drawable.add2_icon));

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(OnlineAuctionJOActivity.this, RecyclerView.HORIZONTAL, false);
        vendorRecycler.setLayoutManager(layoutManager2);
        vendorAdapter = new VendorAdapter(OnlineAuctionJOActivity.this, vendorList);
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



