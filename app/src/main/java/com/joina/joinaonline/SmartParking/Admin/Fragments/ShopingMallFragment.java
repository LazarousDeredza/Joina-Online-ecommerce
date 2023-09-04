package com.joina.joinaonline.SmartParking.Admin.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.joina.joinaonline.JoinaonlineAdmin.Vendors.AddVendorsActivity;
import com.joina.joinaonline.R;


public class ShopingMallFragment extends Fragment {
    Button btnAddVendors;
    private NavController navController;


    public ShopingMallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_shoping_mall, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnAddVendors = view.findViewById(R.id.btnAddVendor);

        navController = Navigation.findNavController(view);

        btnAddVendors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Tenant Added", Toast.LENGTH_LONG).show();

                navController.navigate(R.id.action_shopingMallFragment_to_adminHomeFragment);
            }
        });

    }
}