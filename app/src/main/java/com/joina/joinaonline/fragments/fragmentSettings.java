package com.joina.joinaonline.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.LoginActivity;
import com.joina.joinaonline.R;
public class fragmentSettings extends Fragment implements View.OnClickListener{

    MaterialButton logoutButton, share,call;
    View view;
    public fragmentSettings() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_settings_joinaonline, container, false);

        // Inflate the layout for this fragment
        share = view.findViewById(R.id.tell_your_friend);
        call = view.findViewById(R.id.support);
        logoutButton = view.findViewById(R.id.logoutBtn);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String Body = "Download this app";
                String Sub = "https://play.google.com/store/apps/details?id=com.joina.joinaonline";
                intent.putExtra(Intent.EXTRA_TEXT,Body);
                intent.putExtra(Intent.EXTRA_TEXT, Sub);
                startActivity(Intent.createChooser(intent, "Share using"));
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    @Override
    public void onClick(View v) {
        //
    }
}