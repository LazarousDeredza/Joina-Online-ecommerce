package com.joina.joinaonline.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.joina.joinaonline.AboutApp;
import com.joina.joinaonline.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentMore#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentMore extends Fragment implements View.OnClickListener{

    Button Share,Rate,About;
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentMore() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentMore.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentMore newInstance(String param1, String param2) {
        fragmentMore fragment = new fragmentMore();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_more, container, false);

        About = view.findViewById(R.id.about);
        
        About.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getActivity(), AboutApp.class);
                 startActivity(intent);
             }
         });

        Share = view.findViewById(R.id.share);

        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Android Playstore App Link";

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,message);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose : "));
            }
        });

//        Rate = view.findViewById(R.id.rate);
//        Rate.setOnClickListener(this);
//        About = view.findViewById(R.id.about);
//        About.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}