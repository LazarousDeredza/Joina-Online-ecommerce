package com.joina.joinaonline.Joinaonline.ListStoresActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.joina.joinaonline.Joinaonline.StorefrontLayout;
import com.joina.joinaonline.Joinaonline.adapter.VendorAdapter;
import com.joina.joinaonline.Joinaonline.adapter.VendorResponse;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;

public class FoodAndDrinkListStoresActivity extends AppCompatActivity {

    List<VendorResponse> productList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_and_drink_list_stores);

        RecyclerView productRecycler = findViewById(R.id.storeRecycler);

        productList.add(new VendorResponse(1, "Chicken Hut", "Opposite", "$ 17.00", R.drawable.chicken_hut));
        productList.add(new VendorResponse(2, "KFC", "First floor", "$ 25.00", R.drawable.kfc));
        productList.add(new VendorResponse(3, "Barcelos", "Top floor", "$ 17.00", R.drawable.barcelos));
        productList.add(new VendorResponse(4, "Pizza Hut", "Ground floor", "$ 17.00", R.drawable.pizza_hut));


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        productRecycler.setLayoutManager(layoutManager);
        VendorAdapter vendorAdapter = new VendorAdapter(FoodAndDrinkListStoresActivity.this, productList);
        productRecycler.setAdapter(vendorAdapter);

    }

    public void viewDetails(int pos) {

        Intent intent = new Intent(this, StorefrontLayout.class);
        intent.putExtra("name",productList.get(pos).getProd_name());
        intent.putExtra("floor",productList.get(pos).getPrice());
        intent.putExtra("image",productList.get(pos).getImageUrl());
        startActivity(intent);

    }
}