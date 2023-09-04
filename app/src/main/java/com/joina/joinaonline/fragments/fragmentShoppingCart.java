package com.joina.joinaonline.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.Joinaonline.OrderPayments.ProductCheckoutActivity;

import com.joina.joinaonline.Joinaonline.adapter.CartAdapter;
import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;

public class fragmentShoppingCart extends Fragment implements View.OnClickListener {

    Button Share, Rate, About;
    MaterialButton addMoreProducts, proceedToCheckout, shopNow;
    View view;

    CartAdapter cartAdapter;
    RecyclerView cartRecycler;
    List<Product> cartList = new ArrayList<>();

    public fragmentShoppingCart() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

//        addMoreProducts = view.findViewById(R.id.add_products);
        proceedToCheckout = view.findViewById(R.id.checkout);
        shopNow = view.findViewById(R.id.shop_now);

//        addMoreProducts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(),fragmentHome.class);
//                startActivity(intent);
//            }
//        });

        proceedToCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ProductCheckoutActivity.class);
                startActivity(intent);
            }
        });

        shopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), fragmentHome.class);
                startActivity(intent);
            }
        });



        cartRecycler = view.findViewById(R.id.cart_items_recyclerview);

        cartList.add(new Product(1, "Proton Bread", "5", "brand","ZWL 90", R.drawable.bread));
        cartList.add(new Product(2, "White Sugar", "2","brand","ZWL 217", R.drawable.sugar));
        cartList.add(new Product(3, "Potatoes", "1","brand","ZWL 990", R.drawable.potatoes));
        cartList.add(new Product(4, "Knorrox", "7","brand","ZWL 359", R.drawable.knorrox));
        cartList.add(new Product(5, "Spuds", "4","brand","ZWL 199", R.drawable.spuds));
        cartList.add(new Product(6, "Proton Bread", "5","brand", "ZWL 90", R.drawable.bread));
        cartList.add(new Product(7, "White Sugar", "2","brand","ZWL 217", R.drawable.sugar));
        cartList.add(new Product(8, "Potatoes", "1","brand","ZWL 990", R.drawable.potatoes));
        cartList.add(new Product(9, "Knorrox", "7","brand","ZWL 359", R.drawable.knorrox));
        cartList.add(new Product(10, "Spuds", "4","brand","ZWL 199", R.drawable.spuds));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        cartRecycler.setLayoutManager(layoutManager);
        cartAdapter = new CartAdapter(getContext(), cartList);
        cartRecycler.setAdapter(cartAdapter);


        return view;
    }

    @Override
    public void onClick(View v) {

    }

}