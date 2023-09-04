package com.joina.joinaonline.SmartParking.Admin.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joina.joinaonline.R;


public class PaymentDetailsFragment extends Fragment {

    public PaymentDetailsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_payment_details, container, false);
        TextView textView =view.findViewById(R.id.textCardNumber);

        if (getArguments() != null) {
            String cardNumber = getArguments().getString("cardNumber");

            if (cardNumber != null) {
                textView.setText(cardNumber);
            }
        }
        return view;
    }
}