package com.joina.joinaonline.SmartParking.Admin.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.joina.joinaonline.R;
import com.joina.joinaonline.SmartParking.Admin.Adapters.TagManagementAdapter;
import com.joina.joinaonline.SmartParking.Admin.Adapters.UsersAdapter;
import com.joina.joinaonline.SmartParking.Admin.Interfaces.UsersInterface;
import com.joina.joinaonline.SmartParking.Admin.Models.TagManagementModel;
import com.joina.joinaonline.SmartParking.Admin.Models.UsersModel;

import java.util.ArrayList;

public class SPUsersFragment extends Fragment implements UsersInterface {
    UsersAdapter adapter;
    ArrayList<UsersModel> usersModelArrayList = new ArrayList<>();
    private NavController navController;

    ImageView search;
    SearchView searchView;

    public SPUsersFragment() {
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
        View view = inflater.inflate(R.layout.fragment_s_p_users, container, false);


//        ImageView search =view.findViewById(R.id.searchImage);
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                searchView.setVisibility(View.VISIBLE);
//            }
//        });

//        searchView =view.findViewById(R.id.searchView);
//        searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                filterList(newText);
//                return true;
//            }
//        });

        //first recycler
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        setUpUsersArrayList();

        adapter = new UsersAdapter(requireContext(), usersModelArrayList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        // Call the notifyDataSetChanged() method on the adapter
//        adapter.notifyDataSetChanged();

        return view;
    }

    private void filterList(String text) {
        ArrayList<UsersModel> filteredList = new ArrayList<>();
        for (UsersModel usersModel : usersModelArrayList){
            if (usersModel.getCardNumber().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(usersModel);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(requireContext(), "No data found....", Toast.LENGTH_SHORT).show();
        }else{
            adapter.setFilteredList(filteredList);
        }
    }

    private void setUpUsersArrayList(){



        String[] cardNumber = getResources().getStringArray(R.array.cardNumber);
        String[] parkerName = getResources().getStringArray(R.array.propertyMgt_list_propertyName);
        String[] parkerMobile = getResources().getStringArray(R.array.mobile);
        String[] status = getResources().getStringArray(R.array.cardState);
        String[] startDate = getResources().getStringArray(R.array.startDatee);
        String[] enddate = getResources().getStringArray(R.array.endDatee);

        usersModelArrayList.clear();
        for(int i=0;i<cardNumber.length; i++){
            usersModelArrayList.add(new UsersModel(
                    cardNumber[i],parkerName[i],parkerMobile[i],status[i],startDate[i],enddate[i]
            ));

        }
    };

    @Override
    public void onItemClick(int position, View view) {

        String parkerName = usersModelArrayList.get(position).getParkerName();
        String cardNumber = usersModelArrayList.get(position).getCardNumber();
        String parkerMobile = usersModelArrayList.get(position).getParkerMobile();
        //change to getUserStatus
        String userStatus = usersModelArrayList.get(position).getCardStatus();
        String startDate = usersModelArrayList.get(position).getStartDate();
        String endDate = usersModelArrayList.get(position).getEndDate();


        navController = Navigation.findNavController(view);
        if (parkerName != null) {
            Bundle bundle = new Bundle();
            bundle.putString("parkerName", parkerName);
            bundle.putString("cardNumber", cardNumber);
            bundle.putString("parkerMobile", parkerMobile);
            bundle.putString("userStatus", userStatus);
            bundle.putString("startDate", startDate);
            bundle.putString("endDate", endDate);
            navController.navigate(R.id.action_SPUsersFragment_to_userDetailsFragment, bundle);

        }
    }

    @Override
    public void onOptionClicked(int position, View view) {
        showOptionDialog(position, view);
    }
    private void showOptionDialog(final int position, View view) {
        String[] options = {"Activate", "Suspend"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(options, new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (which) {
                    case 0:

                        String parkerName = usersModelArrayList.get(position).getParkerName();
                        Toast.makeText(getContext(), parkerName+" Card Activated", Toast.LENGTH_SHORT).show();
                        usersModelArrayList.get(position).setCardStatus("Active");

                        // Notify the adapter of the data changes
                        adapter.notifyDataSetChanged();

//                        // Update the data in your adapter (for example, by retrieving new data from a database)
//                        ArrayList<TagManagementModel> newData = getDataFromDatabase();
//                        adapter.setData(newData);
//                          navController.navigate(R.id.action_SPTagManagenentFragment_self);

                        break;
                    case 1:
                        // Handle Suspend option
                        String parkerName1 = usersModelArrayList.get(position).getParkerName();
                        Toast.makeText(getContext(), parkerName1+" Card Suspended", Toast.LENGTH_SHORT).show();
                        usersModelArrayList.get(position).setCardStatus("Suspended");
//                        navController.navigate(R.id.action_SPTagManagenentFragment_self);
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });
        builder.show();
    }
}