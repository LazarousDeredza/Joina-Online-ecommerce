package com.joina.joinaonline.Parking.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joina.joinaonline.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ParkingFragment extends Fragment {


    public ParkingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        // Navigate to see all the requests in the system
        TextView tvRequests = view.findViewById(R.id.tvTagManagementRates);
        tvRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_parkingFragment_to_requestsFragment);
            }
        });

        // navigate to see manage rates
        TextView tvRatesManagement = view.findViewById(R.id.tvManageRates);
        tvRatesManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_parkingFragment_to_ratesManagementFragment);
            }
        });

        // navigate to tag management
        TextView tvTagManagement = view.findViewById(R.id.tvTagManagement);
        tvTagManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_parkingFragment_to_tagManagementFragment);
            }
        });

        // navigate to profile management
        TextView tvProfileManagement = view.findViewById(R.id.tvProfileManagement);
        tvProfileManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_parkingFragment_to_profileManagementFragment);
            }
        });
    }
}