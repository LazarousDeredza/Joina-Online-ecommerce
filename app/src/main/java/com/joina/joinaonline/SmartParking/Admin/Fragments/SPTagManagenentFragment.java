package com.joina.joinaonline.SmartParking.Admin.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.joina.joinaonline.R;
import com.joina.joinaonline.SmartParking.Admin.Adapters.TagManagementAdapter;
import com.joina.joinaonline.SmartParking.Admin.Interfaces.TagManagementInterface;
import com.joina.joinaonline.SmartParking.Admin.Models.TagManagementModel;
import com.joina.joinaonline.SmartParking.Admin.ParkingLog.ParkingLogAdapter;
import com.joina.joinaonline.SmartParking.Admin.ParkingLog.ParkingLogModel;
import com.joina.joinaonline.SmartParking.Admin.ParkingLog.ParkingLogViewModel;
import com.joina.joinaonline.SmartParking.Admin.ViewModel.TagManagementViewModel;

import java.util.ArrayList;


public class SPTagManagenentFragment extends Fragment implements TagManagementInterface {
    private TagManagementViewModel tagManagementViewModel;
    TagManagementAdapter adapter;
    ArrayList<TagManagementModel> tagManagementModelArrayList;
//    ArrayList<TagManagementModel> tagManagementModelArrayList = new ArrayList<>();
    private NavController navController;

    ImageView search;
    SearchView searchView;

    public SPTagManagenentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_s_p_tag_managenent, container, false);


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
//        setUpTagManagementArrayList();

        adapter = new TagManagementAdapter(requireContext(), tagManagementModelArrayList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        tagManagementViewModel = ViewModelProviders.of(this).get(TagManagementViewModel.class);
        tagManagementViewModel.getTagManagementObserver().observe(this, new Observer<ArrayList<TagManagementModel>>() {
            @Override
            public void onChanged(ArrayList<TagManagementModel> tagManagementModels) {
                if(tagManagementModels != null) {
                    tagManagementModelArrayList = tagManagementModels;

                    adapter.setTagManagementModelArrayList(tagManagementModels);

//                    noresult.setVisibility(View.GONE);

                } else {
//                    noresult.setVisibility(View.VISIBLE);
                }
            }
        });
        tagManagementViewModel.getTagManagementViewModel();


        Button Billing = view.findViewById(R.id.addBilling);
        Billing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_SPTagManagenentFragment_to_billingFragment);
            }
        });

         // Call the notifyDataSetChanged() method on the adapter
//        adapter.notifyDataSetChanged();

        return  view;
    }

    private void filterList(String text) {
        ArrayList<TagManagementModel> filteredList = new ArrayList<>();
        for (TagManagementModel tagManagementModel : tagManagementModelArrayList){
            if (tagManagementModel.getCardNumber().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(tagManagementModel);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(requireContext(), "No data found....", Toast.LENGTH_SHORT).show();
        }else{
            adapter.setFilteredList(filteredList);
        }
    }
//    private void setUpTagManagementArrayList(){
//
//        String[] cardNumber = getResources().getStringArray(R.array.cardNumber);
//        String[] parkerName = getResources().getStringArray(R.array.propertyMgt_list_propertyName);
//        String[] parkerMobile = getResources().getStringArray(R.array.mobile);
//        String[] status = getResources().getStringArray(R.array.cardState);
//        String[] startDate = getResources().getStringArray(R.array.startDatee);
//        String[] enddate = getResources().getStringArray(R.array.endDatee);
//
//        tagManagementModelArrayList.clear();
//        for(int i=0;i<cardNumber.length; i++){
//            tagManagementModelArrayList.add(new TagManagementModel(
//                    cardNumber[i],parkerName[i],parkerMobile[i],status[i],startDate[i],enddate[i]
//            ));
//        }
//    };

    @Override
    public void onItemClick(int position, View view) {

        String parkerName = tagManagementModelArrayList.get(position).getParkerName();
        String cardNumber = tagManagementModelArrayList.get(position).getCardNumber();
        String parkerMobile = tagManagementModelArrayList.get(position).getParkerMobile();
        //change to getUserStatus
        String userStatus = tagManagementModelArrayList.get(position).getCardStatus();
        String startDate = tagManagementModelArrayList.get(position).getStartDate();
        String endDate = tagManagementModelArrayList.get(position).getEndDate();

        navController = Navigation.findNavController(view);
        if (parkerName != null) {
            Bundle bundle = new Bundle();
            bundle.putString("parkerName", parkerName);
            bundle.putString("cardNumber", cardNumber);
            bundle.putString("parkerMobile", parkerMobile);
            bundle.putString("userStatus", userStatus);
            bundle.putString("startDate", startDate);
            bundle.putString("endDate", endDate);
            navController.navigate(R.id.action_SPTagManagenentFragment_to_passTagDetailsFragment, bundle);
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
            NavController navController= Navigation.findNavController(view);
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (which) {
                    case 0:
                        String cardNumber = tagManagementModelArrayList.get(position).getCardNumber();
                        Toast.makeText(getContext(), cardNumber+" Card Activated", Toast.LENGTH_SHORT).show();
                        tagManagementModelArrayList.get(position).setCardStatus("Active");

                        // Notify the adapter of the data changes
                        adapter.notifyDataSetChanged();

//                        // Update the data in your adapter (for example, by retrieving new data from a database)
//                        ArrayList<TagManagementModel> newData = getDataFromDatabase();
//                        adapter.setData(newData);
//                          navController.navigate(R.id.action_SPTagManagenentFragment_self);
                        break;
                    case 1:
                        // Handle Suspend option
                        String cardNumber1 = tagManagementModelArrayList.get(position).getCardNumber();
                        Toast.makeText(getContext(), cardNumber1+" Card Suspended", Toast.LENGTH_SHORT).show();
                        tagManagementModelArrayList.get(position).setCardStatus("Suspended");
//                        navController.navigate(R.id.action_SPTagManagenentFragment_self);
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });
        builder.show();
    }
}





