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

public class EventsAndBookingListStoresActivity extends AppCompatActivity {

    List<VendorResponse> productList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_and_booking_list_stores);

        RecyclerView productRecycler = findViewById(R.id.storeRecycler);

        productList.add(new VendorResponse(1, "1", "Opposite", "$ 17.00", R.drawable.add2_icon));
        productList.add(new VendorResponse(2, "2", "First floor", "$ 25.00", R.drawable.add2_icon));
        productList.add(new VendorResponse(3, "3", "Top floor", "$ 17.00", R.drawable.add2_icon));
        productList.add(new VendorResponse(4, "4", "Ground floor", "$ 17.00", R.drawable.add2_icon));


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        productRecycler.setLayoutManager(layoutManager);
        VendorAdapter vendorAdapter = new VendorAdapter(EventsAndBookingListStoresActivity.this, productList);
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