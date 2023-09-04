package com.joina.joinaonline.Joinaonline.OrderPayments.fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.google.gson.Gson;
import com.joina.joinaonline.Joinaonline.BaseActivity;
import com.joina.joinaonline.Joinaonline.JoinaOnlineHomeActivity;
import com.joina.joinaonline.Joinaonline.OrderPayments.CartActivity;
import com.joina.joinaonline.Joinaonline.adapter.master.CheckoutCartAdapter;
import com.joina.joinaonline.R;
import com.joina.joinaonline.SplashScreenActivity;
import com.joina.joinaonline.Supplier;
import com.joina.joinaonline.model.master.Cart;
import com.joina.joinaonline.model.master.Order;
import com.joina.joinaonline.util.localstorage.LocalStorage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class ConfirmFragment extends Fragment {

    LocalStorage localStorage;
    List<Cart> cartList = new ArrayList<>();
    Gson gson;
    RecyclerView recyclerView;
    CheckoutCartAdapter adapter;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    TextView back, placeOrder;
    TextView total, shipping, totalAmount;
    Double _total, _shipping, _totalAmount;
    ProgressDialog progressDialog;
    List<Order> orderList = new ArrayList<>();
    String orderNo;
    String id;
    List<Supplier> suppliers=new ArrayList<>();

    public ConfirmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm, container, false);
        localStorage = new LocalStorage(getContext());
        recyclerView = view.findViewById(R.id.cart_rv);
        totalAmount = view.findViewById(R.id.total_amount);
        total = view.findViewById(R.id.total);
        shipping = view.findViewById(R.id.shipping_amount);
        back = view.findViewById(R.id.back);
        placeOrder = view.findViewById(R.id.place_order);
        progressDialog = new ProgressDialog(getContext());
        gson = new Gson();
        orderList = ((BaseActivity) getActivity()).getOrderList();
        Random rnd = new Random();
        orderNo = "Order #" + (100000 + rnd.nextInt(900000));
        setUpCartRecyclerview();
        if (orderList.isEmpty()) {
            id = "1";
        } else {
            id = String.valueOf(orderList.size() + 1);
        }


        //get boolean delivery from bundle
        //if delivery is true, then shipping is 5.00
        //else shipping is 0.00

     Boolean delivery=localStorage.getDelivery();

        if(delivery) {
           //5 % of total
            _shipping = 0.05 * ((BaseActivity) getActivity()).getTotalPrice();
        }else {
            _shipping = 0.00;
        }


        _total = ((BaseActivity) getActivity()).getTotalPrice();

        _totalAmount = _total + _shipping;
        total.setText(_total + "");
        shipping.setText(_shipping + "");
        totalAmount.setText(_totalAmount + "");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CartActivity.class));
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please Wait....");
                progressDialog.show();
                closeProgress();

            }
        });


         suppliers =((BaseActivity) getActivity()).getSupplierTotal();


        for (Supplier s:suppliers             ) {
            Log.e("",s.getName() +" " + s.getTotalPrice());
        }


        return view;
    }

    private void closeProgress() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                progressDialog.dismiss();
            }
        }, 3000); // 5000 milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        Order order = new Order(id, orderNo, currentDateandTime, "Zwl. " + _totalAmount, "Pending",suppliers);
        orderList.add(order);
        String orderString = gson.toJson(orderList);
        localStorage.setOrder(orderString);
        localStorage.deleteCart();

        showCustomDialog();
    }

    private void showCustomDialog() {

        // Create custom dialog object
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        // Include dialog.xml file
        dialog.setContentView(R.layout.success_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                startActivity(new Intent(getContext(), JoinaOnlineHomeActivity.class));
                getActivity().finish();
            }
        });
        // Set dialog title

        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                dialog.dismiss();
                Intent intent = new Intent(getContext(), JoinaOnlineHomeActivity.class);
                startActivity(intent);
            }
        }, 2500); // 5 seconds delay
    }

    private void setUpCartRecyclerview() {

        cartList = new ArrayList<>();
        cartList = ((BaseActivity) getContext()).getCartList();


        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        adapter = new CheckoutCartAdapter(cartList, getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Confirm");
    }

}