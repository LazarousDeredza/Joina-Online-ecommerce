package com.joina.joinaonline.Joinaonline.SmartParking.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;
public class SmartParkingFragment extends Fragment {
    ImageSlider parkingImageSlider;


    public SmartParkingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_smart_parking, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parkingImageSlider = view.findViewById(R.id.parkingImageSlider);
        List<SlideModel> slideModelList1 = new ArrayList<>();

        slideModelList1.add(new SlideModel("@drawable/parking", "Basement 1", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Basement 2", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "Basement 3", ScaleTypes.FIT));

        parkingImageSlider.setImageList(slideModelList1);

        Button toEnterCard = view.findViewById(R.id.pay);
        Button getBill = view.findViewById(R.id.getBill);
        TextInputLayout etCard =view.findViewById(R.id.cardEt);
        toEnterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etCard.setVisibility(View.VISIBLE);
                getBill.setVisibility(View.VISIBLE);
                toEnterCard.setVisibility(View.GONE);
            }
        });


        getBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etCard.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Proceed to cart.....", Toast.LENGTH_SHORT).show();
                toEnterCard.setVisibility(View.VISIBLE);
                getBill.setVisibility(View.GONE);
            }
        });
    }
}