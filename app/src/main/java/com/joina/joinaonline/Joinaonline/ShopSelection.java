package com.joina.joinaonline.Joinaonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;

public class ShopSelection extends AppCompatActivity {


    ImageView category_image1,category_image2,category_image3,category_image4;
    TextView category_title1,category_title2,category_title3,category_title4;

    CardView card_view1,card_view2,card_view3,card_view4;
    String title;

    ImageSlider imageSlider1;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

       /* Intent intent = new Intent(ShopSelection.this, ProductActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("title",title);
       startActivity(intent);*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_shop);

        category_image1 = findViewById(R.id.category_image1);
        category_image2 = findViewById(R.id.category_image2);
        category_image3 = findViewById(R.id.category_image3);
        category_image4 = findViewById(R.id.category_image4);

        category_title1 = findViewById(R.id.category_title1);
        category_title2 = findViewById(R.id.category_title2);
        category_title3 = findViewById(R.id.category_title3);
        category_title4 = findViewById(R.id.category_title4);

        card_view1 = findViewById(R.id.card_view1);
        card_view2 = findViewById(R.id.card_view2);
        card_view3 = findViewById(R.id.card_view3);
        card_view4 = findViewById(R.id.card_view4);

        imageSlider1 = findViewById(R.id.imageSlider1);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle bundle = getIntent().getExtras();

         title = bundle.getString("title");
        getSupportActionBar().setTitle(title);




        List<SlideModel> slideModelList1 = new ArrayList<>();
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/special-offer-final-sale-banner-600w-1387497926.jpg","PSMAS Promotion", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/99-shopping-day-poster-banner-600w-2024061551.jpg", "Valentines Promotion", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Hello Promo", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "Terrific Tuesday", ScaleTypes.FIT));

        imageSlider1.setImageList(slideModelList1 );


        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopSelection.this, ProductActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopSelection.this, ProductActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        card_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopSelection.this, ProductActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        card_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopSelection.this, ProductActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });


        if(title.toLowerCase().equals("Food & Drink".toLowerCase())){
            category_image1.setImageResource(R.drawable.chicken_hut);
            category_image2.setImageResource(R.drawable.pizza_hut);
            category_image3.setImageResource(R.drawable.kfc);


            category_title1.setText("Chicken Hut");
            category_title2.setText("Pizza Hut");
            category_title3.setText("KFC");

            card_view4.setVisibility(View.GONE);
        } else if (title.toLowerCase().equals("Medical".toLowerCase())) {
            category_image1.setImageResource(R.drawable.lancet);

            category_title1.setText("Lancet");

            card_view2.setVisibility(View.GONE);
            card_view3.setVisibility(View.GONE);
            card_view4.setVisibility(View.GONE);

        }else if(title.toLowerCase().equals("Banking".toLowerCase())){
            category_image1.setImageResource(R.drawable.steward);

            category_title1.setText("Steward Bank");

            card_view2.setVisibility(View.GONE);
            card_view3.setVisibility(View.GONE);
            card_view4.setVisibility(View.GONE);
        } else if (title.toLowerCase().equals("Fashion".toLowerCase())) {
            category_image1.setImageResource(R.drawable.edgars);
            category_image2.setImageResource(R.drawable.posh);

            category_title1.setText("Edgars");
            category_title2.setText("Posh");

            card_view3.setVisibility(View.GONE);
            card_view4.setVisibility(View.GONE);

        } else if (title.toLowerCase().equals("Electronics".toLowerCase())) {
            category_image1.setImageResource(R.drawable.prosputech);

            category_title1.setText("Prosputech");

            card_view2.setVisibility(View.GONE);
            card_view3.setVisibility(View.GONE);
            card_view4.setVisibility(View.GONE);

        } else if (title.toLowerCase().equals("Groceries".toLowerCase())) {
            category_image1.setImageResource(R.drawable.pick_and_pay);

            category_title1.setText("Pick n Pay");

            card_view2.setVisibility(View.GONE);
            card_view3.setVisibility(View.GONE);
            card_view4.setVisibility(View.GONE);

        } else if (title.toLowerCase().equals("entertainment".toLowerCase())) {
            category_image1.setImageResource(R.drawable.light_logo);
            category_image2.setImageResource(R.drawable.light_logo);

            category_title1.setText("Ster Kinekor");
            category_title2.setText("Saints N Sinners");

            card_view3.setVisibility(View.GONE);
            card_view4.setVisibility(View.GONE);


        } else if (title.toLowerCase().equals("Events & Bookings".toLowerCase())) {
            category_image1.setImageResource(R.drawable.light_logo);
            category_image2.setImageResource(R.drawable.light_logo);

            category_title1.setText("Intervel Inc");
            category_title2.setText("Ster Kinekor");

            card_view3.setVisibility(View.GONE);
            card_view4.setVisibility(View.GONE);

        } else if (title.toLowerCase().equals("Online Auction".toLowerCase())) {
            category_image1.setImageResource(R.drawable.light_logo);

            category_title1.setText("LGot Good Auction");

            card_view2.setVisibility(View.GONE);
            card_view3.setVisibility(View.GONE);
            card_view4.setVisibility(View.GONE);

        }


    }




}