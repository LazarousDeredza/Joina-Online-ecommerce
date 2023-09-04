package com.joina.joinaonline.Parking.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.joina.joinaonline.Parking.adapters.Tenants;
import com.joina.joinaonline.Parking.adapters.TenantsAdapter;
import com.joina.joinaonline.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ProfileManagementFragment extends Fragment {


    public ProfileManagementFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile_management, container, false);

        TextView tvUsername = view.findViewById(R.id.tvUsername);
        String username = "Jaison";

        StringBuilder sb = new StringBuilder();
        sb.append("Welcome ").append(username);
        tvUsername.setText(sb);

        ArrayList<Tenants> tenants = new ArrayList<>();

        tenants.add(new Tenants("Cicosy", 10, 100));
        tenants.add(new Tenants("New World", 1, 15));
        tenants.add(new Tenants("Zim WorkX", 10, 23));
        tenants.add(new Tenants("KFC", 0, 20));
        tenants.add(new Tenants("ZB Bank", 2, 45));
        tenants.add(new Tenants("Pick n Pay", -1, 50));
        tenants.add(new Tenants("Steknor", 2, 10));

        RecyclerView recyclerView = view.findViewById(R.id.rvTenants);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        TenantsAdapter adapter = new TenantsAdapter(getContext(), tenants);
        recyclerView.setAdapter(adapter);

        return view;
    }

}