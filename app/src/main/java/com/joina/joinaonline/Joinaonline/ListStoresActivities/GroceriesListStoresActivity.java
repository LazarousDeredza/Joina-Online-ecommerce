package com.joina.joinaonline.Joinaonline.ListStoresActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.joina.joinaonline.Joinaonline.Groceries.GroceriesJOActivity;
import com.joina.joinaonline.Joinaonline.StorefrontLayout;
import com.joina.joinaonline.Joinaonline.adapter.Categories;
import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.Joinaonline.adapter.ProductAdapter;
import com.joina.joinaonline.Joinaonline.adapter.VendorAdapter;
import com.joina.joinaonline.Joinaonline.adapter.VendorResponse;
import com.joina.joinaonline.ProductAdapter2;
import com.joina.joinaonline.R;
import com.joina.joinaonline.model.ProductDto;
import com.joina.joinaonline.viewModel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class GroceriesListStoresActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, productRecycler;
    ProductAdapter2 productAdapter;
    List<Categories> productCategoryList = new ArrayList<>();
    List<ProductDto> productList = new ArrayList<>();

    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries_list_stores);

        productRecycler = findViewById(R.id.storeRecycler);

        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.getProductObserver().observe(this, new Observer<List<ProductDto>>() {

//            Toast.makeText(GroceriesJOActivity.this, "WINNIE ! This is an observer test toast, bro !", Toast.LENGTH_SHORT).show();

            @Override
            public void onChanged(List<ProductDto> products) {
                if(products != null) {
                    productList = products;
                    productAdapter.setProductList(products);

                    Toast.makeText(GroceriesListStoresActivity.this, "List is not EMPTY !",Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(GroceriesListStoresActivity.this, "List is EMPTY !",Toast.LENGTH_SHORT).show();
                }
            }
        });
        productViewModel.getProducts();
        Toast.makeText(GroceriesListStoresActivity.this, "WINNIE ! It worked but something went wrong!",Toast.LENGTH_SHORT).show();

        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(this,2,RecyclerView.VERTICAL, false);
        productRecycler.setLayoutManager(layoutManager1);

        productAdapter = new ProductAdapter2(GroceriesListStoresActivity.this, productList);
        productRecycler.setAdapter(productAdapter);

//        RecyclerView productRecycler = findViewById(R.id.storeRecycler);
//
//        productList.add(new Product(1, "Proton Bread","brand","$ 17.00", R.drawable.bread));
//        productList.add(new Product(2, "White Sugar","brand","$ 25.00", R.drawable.sugar));
//        productList.add(new Product(3, "Potatoes","brand", "$ 17.00", R.drawable.potatoes));
//        productList.add(new Product(4, "Spuds","brand", "$ 17.00", R.drawable.spuds));
//
//
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
//        productRecycler.setLayoutManager(layoutManager);
//        ProductAdapter productAdapter = new ProductAdapter(GroceriesListStoresActivity.this, productList);
//        productRecycler.setAdapter(productAdapter);
    }

//    public void viewDetails(int pos) {
//
//        Intent intent = new Intent(this, StorefrontLayout.class);
//        intent.putExtra("name",productList.get(pos).getProd_name());
//        intent.putExtra("floor",productList.get(pos).getPrice());
//        intent.putExtra("image",productList.get(pos).getImageUrl());
//        startActivity(intent);

//        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
//        productViewModel.getProductObserver().observe(this, new Observer<List<ProductDto>>() {
//            @Override
//            public void onChanged(List<ProductDto> productModels) {
//                if(productModels != null) {
//                    productList = productModels;
//                    adapter.setProductList(productModels);
////                    noresult.setVisibility(View.GONE);
//                } else {
////                    noresult.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        productViewModel.getProducts();
    }