package com.joina.joinaonline.Joinaonline.OrderPayments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.Joinaonline.adapter.CheckoutProductAdapter;
import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;

public class ProductCheckoutActivity extends AppCompatActivity {

    MaterialButton paynowMastercard,paynowEcocash,pay;
    ImageButton addNewCardButton;
    RelativeLayout displayInput,displayNoCardsSaved,displayCardsList;

    RecyclerView ordersListRecycler;
    CheckoutProductAdapter checkoutProductAdapter;
    List<Product> checkoutList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_checkout);

            paynowMastercard = findViewById(R.id.paynow_mastercard);
            paynowEcocash = findViewById(R.id.paynow_ecocash);
            displayInput = findViewById(R.id.display_phonenumber_input_field);
            displayNoCardsSaved = findViewById(R.id.display_no_cards_saved);
            displayCardsList = findViewById(R.id.display_cards_list);
            addNewCardButton = findViewById(R.id.add_new_card_btn);

            paynowEcocash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    paynowEcocash.setBackgroundColor(getResources().getColor(R.color.light_green));
                    paynowMastercard.setBackgroundColor(getResources().getColor(R.color.white));
                    displayNoCardsSaved.setVisibility(view.GONE);
                    displayInput.setVisibility(view.VISIBLE);
                }
            });

        paynowMastercard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    paynowMastercard.setBackgroundColor(getResources().getColor(R.color.light_green));
                    paynowEcocash.setBackgroundColor(getResources().getColor(R.color.white));
                    displayNoCardsSaved.setVisibility(view.VISIBLE);
                    displayInput.setVisibility(view.GONE);
                }
            });

        addNewCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductCheckoutActivity.this,AddCardDetailsActivity.class);
                startActivity(intent);
            }
        });


        ordersListRecycler = findViewById(R.id.orders_list_recycler);

        checkoutList.add(new Product(1, "Proton Bread","brand", "ZWL 90", R.drawable.bread));
        checkoutList.add(new Product(2, "White Sugar","brand", "ZWL 217", R.drawable.sugar));
        checkoutList.add(new Product(3, "Potatoes","brand", "ZWL 990", R.drawable.potatoes));
        checkoutList.add(new Product(4, "Knorrox","brand", "ZWL 359", R.drawable.knorrox));
        checkoutList.add(new Product(5, "Spuds","brand","brand", "ZWL 199", R.drawable.spuds));
        checkoutList.add(new Product(6, "Proton Bread","brand", "ZWL 90", R.drawable.bread));
        checkoutList.add(new Product(7, "White Sugar","brand", "ZWL 217", R.drawable.sugar));
        checkoutList.add(new Product(8, "Potatoes","brand", "ZWL 990", R.drawable.potatoes));
        checkoutList.add(new Product(9, "Knorrox","brand", "ZWL 359", R.drawable.knorrox));
        checkoutList.add(new Product(10, "Spuds","brand", "ZWL 199", R.drawable.spuds));

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(ProductCheckoutActivity.this, RecyclerView.VERTICAL, false);
        ordersListRecycler.setLayoutManager(layoutManager2);
        checkoutProductAdapter = new CheckoutProductAdapter(ProductCheckoutActivity.this, checkoutList);
        ordersListRecycler.setAdapter(checkoutProductAdapter);


    }
}