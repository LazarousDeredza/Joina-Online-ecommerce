package com.joina.joinaonline.Parking.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;

import com.joina.joinaonline.Parking.adapters.TagRequests;
import com.joina.joinaonline.Parking.adapters.TagRequestsAdapter;
import com.joina.joinaonline.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class RequestsFragment extends Fragment {

    FloatingActionButton addFab;
    ExtendedFloatingActionButton addFab1, addFab2;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;

    boolean isOpen = false;

    public RequestsFragment() {
        // Required empty public
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_requests, container, false);

        addFab = view.findViewById(R.id.addFab);
        addFab1 = view.findViewById(R.id.addFab1);
        addFab2 = view.findViewById(R.id.addFab2);

        fabOpen = AnimationUtils.loadAnimation(getContext(), R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(getContext(), R.anim.fab_close);
        rotateForward = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_backward);

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });
        
        addFab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Toast.makeText(getContext(), "Fab 1 Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        
        addFab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Toast.makeText(getContext(), "Add Fab Two Clicked", Toast.LENGTH_SHORT).show();
            }
        });



        // recycler view implementation
        ArrayList<TagRequests> tagRequests = new ArrayList<>();

        Date date = new Date();

        tagRequests.add(new TagRequests("Cicosy", 10,date ));
        tagRequests.add(new TagRequests("New World", 1, date));
        tagRequests.add(new TagRequests("Zim WorkX", 10, date));
        tagRequests.add(new TagRequests("KFC", 0, date));
        tagRequests.add(new TagRequests("ZB Bank", 2, date));
        tagRequests.add(new TagRequests("Pick n Pay", -1, date));
        tagRequests.add(new TagRequests("Steknor", 2, date));
        tagRequests.add(new TagRequests("Steknfdfs", 2, date));

        RecyclerView rvTagRequests = view.findViewById(R.id.rvTagRequests);
        rvTagRequests.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        TagRequestsAdapter adapter = new TagRequestsAdapter(getContext(), tagRequests);
        rvTagRequests.setAdapter(adapter);

        /*
        *
        * View Pager and Tab Layout Implementation
        *
        * */
//        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
//        final ViewPager viewPager = view.findViewById(R.id.viewPager);

        return view;
    }

    private void animateFab() {

        if (isOpen) {
            addFab.startAnimation(rotateForward);
            addFab1.startAnimation(fabClose);
            addFab2.startAnimation(fabClose);

            addFab1.setClickable(false);
            addFab2.setClickable(false);
            isOpen = false;
        } else {
            addFab.startAnimation(rotateBackward);
            addFab1.startAnimation(fabOpen);
            addFab2.startAnimation(fabOpen);

            addFab1.setClickable(true);
            addFab2.setClickable(true);
            isOpen = true;
        }
    }
}