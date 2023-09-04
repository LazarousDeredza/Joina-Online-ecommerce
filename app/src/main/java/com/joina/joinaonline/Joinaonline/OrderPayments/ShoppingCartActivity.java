package com.joina.joinaonline.Joinaonline.OrderPayments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.joina.joinaonline.Joinaonline.adapter.CartAdapter;
import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {

    CartAdapter cartAdapter;
    RecyclerView cartRecycler;
    List<Product> cartList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        cartRecycler = findViewById(R.id.cart_items_recyclerview);

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

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ShoppingCartActivity.this, RecyclerView.VERTICAL, false);
        cartRecycler.setLayoutManager(layoutManager);
        cartAdapter = new CartAdapter(ShoppingCartActivity.this, cartList);
        cartRecycler.setAdapter(cartAdapter);

    }

}




//package com.joina.joinaonline.Joinaonline.OrderPayments;
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//import com.joina.joinaonline.Joinaonline.BaseActivity;
//import com.joina.joinaonline.Joinaonline.adapter.master.CartAdapter;
//import com.joina.joinaonline.MainActivity;
//import com.joina.joinaonline.R;
//import com.joina.joinaonline.model.master.Cart;
//import com.joina.joinaonline.util.localstorage.LocalStorage;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ShoppingCartActivity extends BaseActivity {
//
//    LocalStorage localStorage;
//    List<Cart> cartList = new ArrayList<>();
//    Gson gson;
//    RecyclerView recyclerView;
//    CartAdapter adapter;
//    RecyclerView.LayoutManager recyclerViewlayoutManager;
//
//    RelativeLayout emptyCart;
//    LinearLayout checkoutLL;
//    TextView totalPrice;
//    private String mState = "SHOW_MENU";
////    CartAdapter cartAdapter;
////    RecyclerView cartRecycler;
////    List<Product> cartList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shopping_cart);
//
////        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
//
//
//        localStorage = new LocalStorage(getApplicationContext());
//        gson = new Gson();
//        emptyCart = findViewById(R.id.display_empty_cart_msg);
//        checkoutLL = findViewById(R.id.checkout_LL);
//        totalPrice = findViewById(R.id.total_price);
//        totalPrice.setText("ZWL. " + getTotalPrice() + "");
//        setUpCartRecyclerview();
//
//
//    }
//
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.cart_menu, menu);
////        MenuItem item = menu.findItem(R.id.cart_delete);
////        if (mState.equalsIgnoreCase("HIDE_MENU")) {
////            item.setVisible(false);
////        } else {
////            item.setVisible(true);
////        }
////         return true;
////    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if (item.getItemId() == R.id.cart_delete) {
//            AlertDialog diaBox = showDeleteDialog();
//            diaBox.show();
//            return true;
//        } else if (item.getItemId() == android.R.id.home) {
//            // todo: goto back activity from here
//            Intent intent = new Intent(ShoppingCartActivity.this, MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
//            finish();
//            return true;
//        } else {
//            return super.onOptionsItemSelected(item);
//        }
//    }
//
//
//    private AlertDialog showDeleteDialog() {
//        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
//
//                //set message, title, and icon
//                .setTitle("Delete")
//                .setMessage("Do you want to Delete")
//                .setIcon(R.drawable.ic_delete)
//
//                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        localStorage.deleteCart();
//                        adapter.notifyDataSetChanged();
//                        emptyCart.setVisibility(View.VISIBLE);
//                        mState = "HIDE_MENU";
//                        invalidateOptionsMenu();
//                        dialog.dismiss();
//                    }
//
//                })
//
//                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        dialog.dismiss();
//
//                    }
//                })
//                .create();
//        return myQuittingDialogBox;
//    }
//
//
////    private void changeActionBarTitle(ActionBar actionBar) {
////        // Create a LayoutParams for TextView
////        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
////                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
////                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView
////        TextView tv = new TextView(getApplicationContext());
////        // Apply the layout parameters to TextView widget
////        tv.setLayoutParams(lp);
////        tv.setGravity(Gravity.CENTER);
////        tv.setTypeface(null, Typeface.BOLD);
////        // Set text to display in TextView
////        tv.setText("Cart"); // ActionBar title text
////        tv.setTextSize(20);
////
////        // Set the text color of TextView to red
////        // This line change the ActionBar title text color
////        tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
////
////        // Set the ActionBar display option
////        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
////        // Finally, set the newly created TextView as ActionBar custom view
////        actionBar.setCustomView(tv);
////    }
//
//
//    private void setUpCartRecyclerview() {
//        cartList = new ArrayList<>();
//        cartList = getCartList();
//        if (cartList.isEmpty()) {
//            mState = "HIDE_MENU";
//            invalidateOptionsMenu();
//            emptyCart.setVisibility(View.VISIBLE);
//            checkoutLL.setVisibility(View.GONE);
//        }
//        recyclerView = findViewById(R.id.cart_rv);
//        recyclerView.setHasFixedSize(true);
//        recyclerViewlayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(recyclerViewlayoutManager);
//        adapter = new CartAdapter(cartList, ShoppingCartActivity.this);
//        recyclerView.setAdapter(adapter);
//    }
//
//
//    public void onCheckoutClicked(View view) {
//
////        startActivity(new Intent(getApplicationContext(), CheckoutActivity.class));
//        Toast.makeText(this, "CheckoutActivity", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public void updateTotalPrice() {
//
//        totalPrice.setText("Rs. " + getTotalPrice() + "");
//        if (getTotalPrice() == 0.0) {
//            mState = "HIDE_MENU";
//            invalidateOptionsMenu();
//            emptyCart.setVisibility(View.VISIBLE);
//            checkoutLL.setVisibility(View.GONE);
//        }
//    }
//
//
////
////        cartRecycler = findViewById(R.id.cart_items_recyclerview);
////
////        cartList.add(new Product(1, "Proton Bread", "5", "brand","ZWL 90", R.drawable.bread));
////        cartList.add(new Product(2, "White Sugar", "2","brand","ZWL 217", R.drawable.sugar));
////        cartList.add(new Product(3, "Potatoes", "1","brand","ZWL 990", R.drawable.potatoes));
////        cartList.add(new Product(4, "Knorrox", "7","brand","ZWL 359", R.drawable.knorrox));
////        cartList.add(new Product(5, "Spuds", "4","brand","ZWL 199", R.drawable.spuds));
////        cartList.add(new Product(6, "Proton Bread", "5","brand", "ZWL 90", R.drawable.bread));
////        cartList.add(new Product(7, "White Sugar", "2","brand","ZWL 217", R.drawable.sugar));
////        cartList.add(new Product(8, "Potatoes", "1","brand","ZWL 990", R.drawable.potatoes));
////        cartList.add(new Product(9, "Knorrox", "7","brand","ZWL 359", R.drawable.knorrox));
////        cartList.add(new Product(10, "Spuds", "4","brand","ZWL 199", R.drawable.spuds));
////
////        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ShoppingCartActivity.this, RecyclerView.VERTICAL, false);
////        cartRecycler.setLayoutManager(layoutManager);
////        cartAdapter = new CartAdapter(ShoppingCartActivity.this, cartList);
////        cartRecycler.setAdapter(cartAdapter);
//
//}