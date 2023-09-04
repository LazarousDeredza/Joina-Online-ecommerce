package com.joina.joinaonline.JoinaonlineTenants.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.JoinaonlineTenants.Products.AddProductActivity;
import com.joina.joinaonline.JoinaonlineTenants.fragments.Product.ProductAdapter;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;


public class ProductsFragment extends Fragment {

    CardView productsSort;
    MaterialButton allProducts,addProduct;
    FloatingActionButton addFab;
    View view;
    ProductAdapter productAdapter;
    RecyclerView productRecycler;
    List<Product> productList = new ArrayList<>();

    public ProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_products_joina_tenants, container, false);


        allProducts = view.findViewById(R.id.all_products);

       productsSort = view.findViewById(R.id.products_sort);

        allProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productsSort.setVisibility(View.VISIBLE);
            }
        });

        addFab = view.findViewById(R.id.addFab);
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddProductActivity.class);
                startActivity(intent);
            }
        });

        productRecycler = view.findViewById(R.id.rvVendorProducts);

        productList.add(new Product(1, "Proton Bread", "brand","ZWL 90", R.drawable.bread));
        productList.add(new Product(2, "White Sugar","brand","ZWL 217", R.drawable.sugar));
        productList.add(new Product(3, "Potatoes","brand","ZWL 990", R.drawable.potatoes));
        productList.add(new Product(4, "Knorrox","brand","ZWL 359", R.drawable.knorrox));
        productList.add(new Product(5, "Spuds","brand","ZWL 199", R.drawable.spuds));
        productList.add(new Product(6, "Proton Bread","brand", "ZWL 90", R.drawable.bread));
        productList.add(new Product(7, "White Sugar","brand","ZWL 217", R.drawable.sugar));
        productList.add(new Product(8, "Potatoes","brand","ZWL 990", R.drawable.potatoes));
        productList.add(new Product(9, "Knorrox","brand","ZWL 359", R.drawable.knorrox));
        productList.add(new Product(10, "Spuds","brand","ZWL 199", R.drawable.spuds));
        productList.add(new Product(11, "Proton Bread", "brand","ZWL 90", R.drawable.bread));
        productList.add(new Product(12, "White Sugar","brand","ZWL 217", R.drawable.sugar));
        productList.add(new Product(13, "Potatoes","brand","ZWL 990", R.drawable.potatoes));
        productList.add(new Product(14, "Knorrox","brand","ZWL 359", R.drawable.knorrox));
        productList.add(new Product(15, "Spuds","brand","ZWL 199", R.drawable.spuds));
        productList.add(new Product(16, "Proton Bread","brand", "ZWL 90", R.drawable.bread));
        productList.add(new Product(17, "White Sugar","brand","ZWL 217", R.drawable.sugar));
        productList.add(new Product(18, "Potatoes","brand","ZWL 990", R.drawable.potatoes));
        productList.add(new Product(19, "Knorrox","brand","ZWL 359", R.drawable.knorrox));
        productList.add(new Product(20, "Spuds","brand","ZWL 199", R.drawable.spuds));
        productList.add(new Product(21, "Proton Bread", "brand","ZWL 90", R.drawable.bread));
        productList.add(new Product(22, "White Sugar","brand","ZWL 217", R.drawable.sugar));
        productList.add(new Product(23, "Potatoes","brand","ZWL 990", R.drawable.potatoes));
        productList.add(new Product(24, "Knorrox","brand","ZWL 359", R.drawable.knorrox));
        productList.add(new Product(25, "Spuds","brand","ZWL 199", R.drawable.spuds));
        productList.add(new Product(26, "Proton Bread","brand", "ZWL 90", R.drawable.bread));
        productList.add(new Product(27, "White Sugar","brand","ZWL 217", R.drawable.sugar));
        productList.add(new Product(28, "Potatoes","brand","ZWL 990", R.drawable.potatoes));
        productList.add(new Product(29, "Knorrox","brand","ZWL 359", R.drawable.knorrox));
        productList.add(new Product(30, "Spuds","brand","ZWL 199", R.drawable.spuds));
        productList.add(new Product(31, "Proton Bread", "brand","ZWL 90", R.drawable.bread));
        productList.add(new Product(32, "White Sugar","brand","ZWL 217", R.drawable.sugar));
        productList.add(new Product(33, "Potatoes","brand","ZWL 990", R.drawable.potatoes));
        productList.add(new Product(34, "Knorrox","brand","ZWL 359", R.drawable.knorrox));
        productList.add(new Product(35, "Spuds","brand","ZWL 199", R.drawable.spuds));
        productList.add(new Product(36, "Proton Bread","brand", "ZWL 90", R.drawable.bread));
        productList.add(new Product(37, "White Sugar","brand","ZWL 217", R.drawable.sugar));
        productList.add(new Product(38, "Potatoes","brand","ZWL 990", R.drawable.potatoes));
        productList.add(new Product(39, "Knorrox","brand","ZWL 359", R.drawable.knorrox));
        productList.add(new Product(40, "Spuds","brand","ZWL 199", R.drawable.spuds));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        productRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(getContext(),productList);
        productRecycler.setAdapter(productAdapter);


        return view;

    }

}







