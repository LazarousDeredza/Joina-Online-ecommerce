package com.joina.joinaonline.JoinaonlineTenants.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.JoinaonlineTenants.Dashboard.Requests.RequestsActivity;
import com.joina.joinaonline.JoinaonlineTenants.Products.AddProductActivity;
import com.joina.joinaonline.JoinaonlineTenants.Dashboard.PaymentsActivity;
import com.joina.joinaonline.JoinaonlineTenants.Settings.ShopProfileActivity;
import com.joina.joinaonline.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard_joina_tenants, container, false);

        MaterialButton profile_button=view.findViewById(R.id.profile_button);
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShopProfileActivity.class);
                startActivity(intent);
            }
        });

        MaterialButton addProducts = view.findViewById(R.id.add_product);
        addProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddProductActivity.class);
                startActivity(intent);
            }
        });

        MaterialButton makeRequests = view.findViewById(R.id.make_requests);
        makeRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RequestsActivity.class);
                startActivity(intent);
            }
        });

        TextView viewPayments = view.findViewById(R.id.view_payment_settings);
        viewPayments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PaymentsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}