package com.joina.joinaonline.JoinaonlineTenants.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.joina.joinaonline.JoinaonlineTenants.fragments.Orders.OrdersAdapter;
import com.joina.joinaonline.JoinaonlineTenants.fragments.Orders.OrdersModelClass;
import com.joina.joinaonline.R;

import java.util.ArrayList;


public class OrdersFragment extends Fragment {
    ArrayList<OrdersModelClass> ordersModelClassArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_orders_joina_tenants, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.ordersRecyclerView);

        setUpOrdersList();

        OrdersAdapter adapter = new OrdersAdapter(getContext(), ordersModelClassArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
    private void setUpOrdersList(){
        String[] orderNumber = getResources().getStringArray(R.array.orderNumber);
        String[] userName = getResources().getStringArray(R.array.userName);
        String[] totalPrice = getResources().getStringArray(R.array.totalPrice);
        String[] status = getResources().getStringArray(R.array.oStatus);

        for(int i=0;i<orderNumber.length; i++) {
            ordersModelClassArrayList.add(new OrdersModelClass(
                    orderNumber[i], userName[i], totalPrice[i], status[i]
            ));
        }
    };
}