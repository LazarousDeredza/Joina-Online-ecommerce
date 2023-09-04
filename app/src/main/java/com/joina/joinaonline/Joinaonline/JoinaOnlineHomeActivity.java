package com.joina.joinaonline.Joinaonline;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.joina.joinaonline.Joinaonline.Interfaces.LogoInterface;
import com.joina.joinaonline.Joinaonline.OrderPayments.CartActivity;
import com.joina.joinaonline.Joinaonline.adapter.Logo;
import com.joina.joinaonline.Joinaonline.adapter.LogoAdapter;
import com.joina.joinaonline.Joinaonline.helper.Converter;
import com.joina.joinaonline.JoinaonlineAdmin.CategoryRequests.JoinaAdminCategoryRequestsActivity;
import com.joina.joinaonline.JoinaonlineAdmin.JoinaAdminMainActivity;
import com.joina.joinaonline.R;
import com.joina.joinaonline.model.master.User;
import com.joina.joinaonline.util.localstorage.LocalStorage;

import java.util.ArrayList;
import java.util.List;

public class JoinaOnlineHomeActivity extends BaseActivity implements LogoInterface {

    private LogoAdapter logoAdapter;
    private static int cart_count = 0;
//    User user;

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    List<Logo> logoList = new ArrayList<>();

    MaterialButton cartButton;


    User user;
    MaterialButton search;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joina_online_home);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        cart_count = cartCount();

        localStorage = new LocalStorage(getApplicationContext());
        String userString = localStorage.getUserLogin();
        Gson gson = new Gson();
        userString = localStorage.getUserLogin();
        user = gson.fromJson(userString, User.class);

        RecyclerView logoRecycler;

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        NavController navController = Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

//            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                    int itemId = item.getItemId();
//                    if (itemId == R.id.JoinaOnlineHomeFragment) {
//                        navController.navigate(R.id.JoinaOnlineHomeFragment);
//                        return true;
//                    } else if (itemId == R.id.shoppingCart) {
//                        navController.navigate(R.id.action_JoinaOnlineHomeFragment_to_shoppingCartActivity);
//                        return true;
//                    } else if (itemId == R.id.fragmentSettings) {
//                        navController.navigate(R.id.action_JoinaOnlineHomeFragment_to_fragmentSettings);
//                        return true;
//                    } else {
//                        return false;
//                    }
//
//                }
//            });


        logoRecycler = findViewById(R.id.logo_recycler);


        logoList.add(new Logo( R.drawable.edgars, "Edgars"));
        logoList.add(new Logo(R.drawable.econet, "Econet"));
        logoList.add(new Logo(R.drawable.pizza_hut,"Pizza_hut"));
        logoList.add(new Logo(R.drawable.bata, "Bata"));
        logoList.add(new Logo(R.drawable.steward, "Steward bank"));
        logoList.add(new Logo(R.drawable.kfc, "kfc"));
        logoList.add(new Logo(R.drawable.lancet, "lancet"));
        logoList.add(new Logo(R.drawable.telecel, "telecel"));
        logoList.add(new Logo(R.drawable.psmas, "psmas"));
        logoList.add(new Logo(R.drawable.prosputech, "prosputech"));
        logoList.add(new Logo(R.drawable.manupac, "manupac"));
        logoList.add(new Logo(R.drawable.chicken_hut, "chicken_hut"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(JoinaOnlineHomeActivity.this, RecyclerView.HORIZONTAL, false);
        logoRecycler.setLayoutManager(layoutManager);
        logoAdapter = new LogoAdapter(JoinaOnlineHomeActivity.this, logoList, this);
        logoRecycler.setAdapter(logoAdapter);

        TextView slideTextView = findViewById(R.id.slideText);
        slideTextView.setSingleLine(true);
        slideTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        slideTextView.setMarqueeRepeatLimit(-1);
        slideTextView.setFocusable(true);
        slideTextView.setFocusableInTouchMode(true);
        slideTextView.requestFocus();
        slideTextView.setSelected(true);


        search = findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        // Create a new search view
                        SearchView searchView = new SearchView(JoinaOnlineHomeActivity.this);

                        // Create a new alert dialog with the search view
                        AlertDialog.Builder builder = new AlertDialog.Builder(JoinaOnlineHomeActivity.this);
                        builder.setTitle("Search");
                        builder.setView(searchView);
                        builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Handle search button click
                                String query = searchView.getQuery().toString();
                                // Perform search with the query string

                                searchView.clearFocus();

                                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                    @Override
                                    public boolean onQueryTextSubmit(String query) {
                                        return false;
                                    }

                                    @Override
                                    public boolean onQueryTextChange(String newText) {
                                        filterList(newText);
                                        return true;
                                    }
                                    private void filterList(String text) {
//                                        ArrayList<Logo> filteredList = new ArrayList<>();
                                        List<Logo> filteredList = new ArrayList<>();
                                        for (Logo logoModel : logoList){
                                            if (logoModel.getName().toLowerCase().contains(text.toLowerCase())){
                                                filteredList.add(logoModel);
                                            }
                                        }
                                        if(filteredList.isEmpty()){
                                            Toast.makeText(JoinaOnlineHomeActivity.this, "No data found....", Toast.LENGTH_SHORT).show();
                                        }else{
                                            logoAdapter.setFilteredList(filteredList);
                                        }
                                    }
                                });

                                Toast.makeText(JoinaOnlineHomeActivity.this, "successful", Toast.LENGTH_SHORT).show();

                            }
                        });

                        builder.setNegativeButton("Cancel", null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
        });

//        cartButton = findViewById(R.id.cart_action);
//
//        cartButton.setIcon(Converter.convertLayoutToImage(JoinaOnlineHomeActivity.this, cart_count, R.drawable.icon_shopping_cart));
//
//
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(JoinaOnlineHomeActivity.this, cart_count, R.drawable.icon_shopping_cart));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.cart_action) {
            startActivity(new Intent(getApplicationContext(), CartActivity.class));
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onItemClick(int position, View view) {
        int imageUrl = logoList.get(position).getImageUrl();
        String name = logoList.get(position).getName();

        navController = Navigation.findNavController(view);
        if (name != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("imageUrl", imageUrl);
            bundle.putString("name", name);

            navController.navigate(R.id.directoryFragment, bundle);
        }

    }

    @Override
    public void onAddProduct() {
        super.onAddProduct();
        cart_count++;
        invalidateOptionsMenu();

    }

    @Override
    public void onRemoveProduct() {
        super.onRemoveProduct();
    }

}


