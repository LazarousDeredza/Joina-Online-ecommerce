package com.joina.joinaonline.Joinaonline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import com.joina.joinaonline.Joinaonline.adapter.VendorAdapter;
import com.joina.joinaonline.Joinaonline.adapter.VendorResponse;
import com.joina.joinaonline.R;

public class StorefrontLayout extends AppCompatActivity {

    int position;
    String title;
    ImageView shop_logo;
    TextView shop_name;
    TextView shop_location;


//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storefront_layout);

        shop_name = findViewById(R.id.shop_name);
        shop_location = findViewById(R.id.shop_location);
        shop_logo = findViewById(R.id.shop_logo);

        Intent i = getIntent();

        String name = i.getStringExtra("name");
        String floor = i.getStringExtra("floor");
        int imageUrl = i.getIntExtra("image",0);

        shop_name.setText(name);
        shop_location.setText(floor);
        shop_logo.setImageResource(imageUrl);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);

//            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                @Override
//                public boolean onQueryTextSubmit(String s) {
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String s) {
//                    return false;
//                }
//            });

        return super.onCreateOptionsMenu(menu);
    }


}
