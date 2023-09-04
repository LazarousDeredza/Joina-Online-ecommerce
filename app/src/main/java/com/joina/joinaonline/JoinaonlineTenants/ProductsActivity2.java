package com.joina.joinaonline.JoinaonlineTenants;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.JoinaonlineTenants.Products.AddProductActivity;
import com.joina.joinaonline.R;
import com.joina.joinaonline.viewModel.TaxViewModel;

public class ProductsActivity2 extends AppCompatActivity {

    MaterialButton addProduct,allProducts;
    CardView productsSort;

    TaxViewModel taxViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products2);

        addProduct = findViewById(R.id.add_product);

        taxViewModel = ViewModelProviders.of(this).get(TaxViewModel.class);

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductsActivity2.this, AddProductActivity.class);
                startActivity(intent);
            }
        });

        allProducts = findViewById(R.id.all_products);
        productsSort = findViewById(R.id.products_sort);

        allProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productsSort.setVisibility(View.VISIBLE);
            }
        });

    }
}