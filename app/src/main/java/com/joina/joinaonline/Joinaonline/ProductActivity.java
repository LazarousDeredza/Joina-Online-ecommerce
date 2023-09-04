package com.joina.joinaonline.Joinaonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.joina.joinaonline.Joinaonline.OrderPayments.CartActivity;
import com.joina.joinaonline.Joinaonline.adapter.master.ProductAdapter;
import com.joina.joinaonline.Joinaonline.helper.Converter;
import com.joina.joinaonline.Joinaonline.helper.Data;
import com.joina.joinaonline.R;

public class ProductActivity extends BaseActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    private static int cart_count = 0;
    Data data;
    ProductAdapter mAdapter;
    String Tag = "List";
    String title;
    private RecyclerView recyclerView;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle bundle = getIntent().getExtras();

        title = bundle.getString("title");
        getSupportActionBar().setTitle(title);


        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        //upArrow.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        cart_count = cartCount();
        recyclerView = findViewById(R.id.product_rv);
        data = new Data();
        setUpRecyclerView();


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        // Set up the hamburger icon
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle item clicks here
                switch (item.getItemId()) {
                   /* case R.id.nav_item1:
                        // Handle item 1 click
                        break;
                    case R.id.nav_item2:
                        // Handle item 2 click
                        break;
                    case R.id.nav_item3:
                        // Handle item 3 click*/
                    //  break;
                }

                // Close the drawer after handling the item click
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }

    private void changeActionBarTitle(ActionBar actionBar) {
        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView
        TextView tv = new TextView(getApplicationContext());
        // Apply the layout parameters to TextView widget
        tv.setLayoutParams(lp);
        tv.setGravity(Gravity.CENTER);
        tv.setTypeface(null, Typeface.BOLD);
        // Set text to display in TextView
        tv.setText("Products"); // ActionBar title text
        tv.setTextSize(20);

        // Set the text color of TextView to red
        // This line change the ActionBar title text color
        tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        // Set the ActionBar display option
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // Finally, set the newly created TextView as ActionBar custom view
        actionBar.setCustomView(tv);
    }

    private void setUpRecyclerView() {
        data = new Data();
        mAdapter = new ProductAdapter(data.getProductList(title.toLowerCase()), ProductActivity.this, Tag);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    private void setUpGridRecyclerView() {
        data = new Data();
        mAdapter = new ProductAdapter(data.getProductList(title), ProductActivity.this, Tag);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    public void onToggleClicked(View view) {
        if (Tag.equalsIgnoreCase("List")) {
            Tag = "Grid";
            setUpGridRecyclerView();
        } else {
            Tag = "List";
            setUpRecyclerView();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            // todo: goto back activity from here
            Intent intent = new Intent(ProductActivity.this, JoinaOnlineHomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        } else if (item.getItemId() == R.id.cart_action) {
            startActivity(new Intent(getApplicationContext(), CartActivity.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(ProductActivity.this, cart_count, R.drawable.icon_shopping_cart));
        return true;
    }


    @Override
    public void onAddProduct() {
        cart_count++;
        invalidateOptionsMenu();

    }

    @Override
    public void onRemoveProduct() {
        cart_count--;
        invalidateOptionsMenu();

    }

}