package com.joina.joinaonline.SmartParking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.joina.joinaonline.R;
public class AdminHomeFragment extends Fragment {
    private NavController navController;

    public AdminHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_home, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button shoppingMall = view.findViewById(R.id.shopingMall);
        navController = Navigation.findNavController(view);

        shoppingMall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String message = "Hello DetailFragment!";
//
//                if (message != null) {
//                    Bundle bundle = new Bundle();
//                    bundle.putString("message", message);
//                    navController.navigate(R.id.action_homeFragment_to_detailFragment, bundle);
                navController.navigate(R.id.action_adminHomeFragment_to_shopingMallFragment);

//                }
            }
        });

//        Button officesAndTenants = view.findViewById(R.id.officesAndTenants);
//        navController = Navigation.findNavController(view);
//
//        officesAndTenants.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String message = "Hello DetailFragment!";
////
////                if (message != null) {
////                    Bundle bundle = new Bundle();
////                    bundle.putString("message", message);
////                    navController.navigate(R.id.action_homeFragment_to_detailFragment, bundle);
//                navController.navigate(R.id.action_adminHomeFragment_to_officesAndTenantFragment);
////                }
//            }
//        });
//
//        Button manageTags = view.findViewById(R.id.manageParking);
//        navController = Navigation.findNavController(view);
//
//        manageTags.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String message = "Hello DetailFragment!";
//
////                if (message != null) {
////                    Bundle bundle = new Bundle();
////                    bundle.putString("message", message);
////                    navController.navigate(R.id.action_homeFragment_to_detailFragment, bundle);
//                navController.navigate(R.id.action_adminHomeFragment_to_SPTagManagenentFragment);
////                }
//            }
//        });

        Button viewUsers = view.findViewById(R.id.viewUsers);
        navController = Navigation.findNavController(view);

        viewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_adminHomeFragment_to_SPUsersFragment);
            }
        });

        TextView viewStatements = view.findViewById(R.id.statements);
        navController = Navigation.findNavController(view);

        viewStatements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_adminHomeFragment_to_SPPaymentsFragment);
            }
        });

    }
}