package com.joina.joinaonline.Joinaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.Joinaonline.OrderPayments.ProductCheckoutActivity;
import com.joina.joinaonline.Joinaonline.OrderPayments.ShoppingCartActivity;
import com.joina.joinaonline.R;
import com.joina.joinaonline.fragments.fragmentShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class OnClickSingleProductActivity extends AppCompatActivity {

    MaterialButton addToCart,instantBuy;
    ImageButton decrementButton, incrementButton;
    TextView productQuantity;
    ImageSlider imageSlider;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_single_product);

        imageSlider = findViewById(R.id.imageSlider);

        List<SlideModel> slideModelList = new ArrayList<>();
        slideModelList.add(new SlideModel(R.drawable.bread, ScaleTypes.FIT));
        slideModelList.add(new SlideModel(R.drawable.spuds, ScaleTypes.FIT));
        slideModelList.add(new SlideModel(R.drawable.knorrox, ScaleTypes.FIT));
        imageSlider.setImageList(slideModelList);


        productQuantity = findViewById(R.id.product_quantity);

        decrementButton = findViewById(R.id.decrement_button);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        incrementButton = findViewById(R.id.increment_button);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                score += 1;
//                productQuantity.setText(score);


//                CharSequence value = productQuantity.getText();
//                int num = Integer.parseInt(value.toString());
//                ++num;
//                productQuantity.setText(num);

            }
        });

        addToCart = findViewById(R.id.cart);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnClickSingleProductActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

        instantBuy = findViewById(R.id.instant_buy);

        instantBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnClickSingleProductActivity.this, ProductCheckoutActivity.class);
                startActivity(intent);
            }
        });



    }
}