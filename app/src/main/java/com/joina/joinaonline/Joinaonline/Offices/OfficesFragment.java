package com.joina.joinaonline.Joinaonline.Offices;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;
import com.joina.joinaonline.R;
import com.joina.joinaonline.Tenants.GuestUser.TenantsGuestApplicationUploadActivity;

import java.util.ArrayList;
import java.util.List;


public class OfficesFragment extends Fragment {

    ImageSlider officesImageSlider;
    Spinner line_Of_Business_Spinner;
    String [] lineOfBusiness ={"Technology","Wholesale", "Real Estate", "Hedge Fund"};

    private NavController navController;

    public OfficesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_offices, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        officesImageSlider = view.findViewById(R.id.officesImageSlider);
        List<SlideModel> slideModelList1 = new ArrayList<>();

        slideModelList1.add(new SlideModel("@drawable/parking", "Offices", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Shops", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "Cubicles", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Meeting rooms", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "Conference room", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "BoardRooms", ScaleTypes.FIT));

        officesImageSlider.setImageList(slideModelList1);

        Button apply = view.findViewById(R.id.apply);
        Button goToUpload = view.findViewById(R.id.goToUpoad);
        MaterialCardView form =view.findViewById(R.id.form);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                form.setVisibility(View.VISIBLE);
                apply.setVisibility(View.GONE);
            }
        });

        navController = Navigation.findNavController(view);
        goToUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_officesFragment_to_officeUploadDocsFragment);
            }
        });

        line_Of_Business_Spinner = view.findViewById(R.id.lineOfBusinessSpinner);
        ArrayAdapter managerArray = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, lineOfBusiness);
        managerArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        line_Of_Business_Spinner.setAdapter(managerArray);
    }
}