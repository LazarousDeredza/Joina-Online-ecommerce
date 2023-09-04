package com.joina.joinaonline.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import com.joina.joinaonline.Adverts.AdvertsHomeActivity;
import com.joina.joinaonline.Amusement.AmusementHomeActivity;
import com.joina.joinaonline.Building.BuildingHomeActivity;
import com.joina.joinaonline.Events.EventsHomeActivity;
import com.joina.joinaonline.JoinaOnlineNavActivity;
import com.joina.joinaonline.Joinaonline.JoinaOnlineHomeActivity;
import com.joina.joinaonline.Offices.OfficesHomeActivity;
import com.joina.joinaonline.Parking.ParkingHomeActivity;
import com.joina.joinaonline.R;
import com.joina.joinaonline.SmartParking.SmartParkingActivity;
import com.joina.joinaonline.Systems.SystemsHomeActivity;
import com.joina.joinaonline.Tenants.TenantAuthActivity;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class fragmentHome extends Fragment {

    MaterialButton adverts, amusement, building, joina, parking, events, offices, tenants, systems;

    public fragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        adverts = view.findViewById(R.id.adverts);
        amusement = view.findViewById(R.id.amusement);
        building = view.findViewById(R.id.building);
        joina = view.findViewById(R.id.joina);
        parking = view.findViewById(R.id.parking);
        tenants = view.findViewById(R.id.tenants);
        events = view.findViewById(R.id.events);
        systems = view.findViewById(R.id.systems);
        offices = view.findViewById(R.id.offices);

        offices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OfficesHomeActivity.class);
                startActivity(intent);
            }
        });

        systems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SystemsHomeActivity.class);
                startActivity(intent);
            }
        });

        adverts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdvertsHomeActivity.class);
                startActivity(intent);
            }
        });

        amusement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AmusementHomeActivity.class);
                startActivity(intent);
            }
        });

        building.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BuildingHomeActivity.class);
                startActivity(intent);
            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventsHomeActivity.class);
                startActivity(intent);
            }
        });

        joina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), JoinaOnlineNavActivity.class);
                startActivity(intent);
            }
        });

        parking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SmartParkingActivity.class);
                startActivity(intent);
            }
        });


        tenants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TenantAuthActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}