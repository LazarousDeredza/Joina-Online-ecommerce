package com.joina.joinaonline.SmartParking.Admin.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joina.joinaonline.R;

public class PassTagDetailsFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pass_tag_details, container, false);

        TextView parkerNameTv =view.findViewById(R.id.parkerName);
        TextView cardNumberTv =view.findViewById(R.id.cardNumber);
        TextView parkerMobileTv =view.findViewById(R.id.parkerMobile);
        TextView userStatusTv =view.findViewById(R.id.userStatus);
        TextView startDateTv =view.findViewById(R.id.startDate);
        TextView endDateTv =view.findViewById(R.id.endDate);

        if (getArguments() != null) {
            String parkerName = getArguments().getString("parkerName");
            String cardNumber = getArguments().getString("cardNumber");
            String parkerMobile = getArguments().getString("parkerMobile");
            String userStatus = getArguments().getString("userStatus");
            String startDate = getArguments().getString("startDate");
            String endDate = getArguments().getString("endDate");

            if (parkerName != null) {
                parkerNameTv.setText(parkerName);
            }
            if (cardNumber != null) {
                cardNumberTv.setText(cardNumber);
            }
            if (parkerMobile != null) {
                parkerMobileTv.setText(parkerMobile);
            }
            if (userStatus != null) {
                userStatusTv.setText(userStatus);
            }
            if (startDate != null) {
                startDateTv.setText(startDate);
            }
            if (endDate != null) {
                endDateTv.setText(endDate);
            }

        }
        return view;
    }

}