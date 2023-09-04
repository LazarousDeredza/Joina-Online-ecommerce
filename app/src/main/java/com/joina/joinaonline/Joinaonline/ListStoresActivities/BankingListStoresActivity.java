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

public class BankingListStoresActivity extends AppCompatActivity {


    List<VendorResponse> productList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking_list_stores);

        RecyclerView productRecycler = findViewById(R.id.storeRecycler);

        productList.add(new VendorResponse(1, "Steward Bank", "Opposite", "$ 17.00", R.drawable.steward));
        productList.add(new VendorResponse(2, "NMB Bank", "First floor", "$ 25.00", R.drawable.nmb));
        productList.add(new VendorResponse(3, "Ecobank", "Top floor", "$ 17.00", R.drawable.ecobank));
        productList.add(new VendorResponse(4, "ZB Bank", "Ground floor", "$ 17.00", R.drawable.zb));


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        productRecycler.setLayoutManager(layoutManager);
        VendorAdapter vendorAdapter = new VendorAdapter(BankingListStoresActivity.this, productList);
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