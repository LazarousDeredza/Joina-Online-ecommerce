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

public class MedicalListStoresActivity extends AppCompatActivity {

    List<VendorResponse> productList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_list_stores);

        RecyclerView productRecycler = findViewById(R.id.storeRecycler);

        productList.add(new VendorResponse(1, "PSMAS", "Opposite", "$ 17.00", R.drawable.psmas));
        productList.add(new VendorResponse(2, "Lancet", "First floor", "$ 25.00", R.drawable.lancet));
        productList.add(new VendorResponse(3, "Sandy's Health", "Top floor", "$ 17.00", R.drawable.sandy));
        productList.add(new VendorResponse(4, "Hillcrest", "Ground floor", "$ 17.00", R.drawable.hillcrest));


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        productRecycler.setLayoutManager(layoutManager);
        VendorAdapter vendorAdapter = new VendorAdapter(MedicalListStoresActivity.this, productList);
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