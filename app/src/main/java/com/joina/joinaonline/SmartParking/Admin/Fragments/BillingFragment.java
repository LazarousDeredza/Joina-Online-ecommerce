package com.joina.joinaonline.SmartParking.Admin.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.joina.joinaonline.R;


public class BillingFragment extends Fragment {

    public BillingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_billing, container, false);
        
        Button rates = view.findViewById(R.id.btnSaveRates);
        rates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "rates updated", Toast.LENGTH_SHORT).show();
            }
        });


        
        
        
        
        
        
        
        
        
        
        
        
        
        

//        String[] items = {"Casual", "Tenant", "VIP"};

//        Spinner spinner = view.findViewById(R.id.spinner);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, items);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        spinner.setAdapter(adapter);


        return view;
    }
}