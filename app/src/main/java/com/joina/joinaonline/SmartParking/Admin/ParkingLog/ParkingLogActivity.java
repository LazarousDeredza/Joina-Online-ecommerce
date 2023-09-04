package com.joina.joinaonline.SmartParking.Admin.ParkingLog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.R;
import com.joina.joinaonline.model.Category;
import com.joina.joinaonline.viewModel.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class ParkingLogActivity extends AppCompatActivity implements ParkinglogInterface {

    private ParkingLogViewModel parkingLogViewModel;
//    ArrayList<ParkingLogModel> parkingLogList1;
    ParkingLogAdapter adapter;
//    ParkingLogAdapter adapter1;
    ArrayList<ParkingLogModel> parkingLogList1;
//    ArrayList<ParkingLogModel> parkingLogList2 = new ArrayList<>();

    private NavController navController;

    ImageView search;
    SearchView searchView;

    private RecyclerView recyclerView;
    private RadioGroup mFilterRadioGroup;
    private String mFilterOption = "All"; // Default filter option

    public  ParkingLogActivity(){
        // Required empty public
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_log);

        ImageView search =findViewById(R.id.searchImage);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setVisibility(View.VISIBLE);
            }
        });

        searchView =findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterRecyclerView(newText);
                return false;
            }
        });

        // Get references to views
        mFilterRadioGroup = findViewById(R.id.filter_radio_group);

        // Set up radio group listener
        mFilterRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Get selected radio button text
                RadioButton selectedRadioButton = findViewById(checkedId);
                mFilterOption = selectedRadioButton.getText().toString();

                // Call method to filter the RecyclerView
                filterRecyclerView("");
            }
            });

        recyclerView = findViewById(R.id.recycler);
//        setUpParkLogArrayList1();

        adapter = new ParkingLogAdapter(this, parkingLogList1, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        parkingLogViewModel = ViewModelProviders.of(this).get(ParkingLogViewModel.class);
        parkingLogViewModel.getPassLogLObserver().observe(this, new Observer<ArrayList<ParkingLogModel>>() {
            @Override
            public void onChanged(ArrayList<ParkingLogModel> parkingLogModels) {
                if(parkingLogModels != null) {
                    parkingLogList1 = parkingLogModels;

                    adapter.setParkingLogModelArrayList(parkingLogModels);
//                    noresult.setVisibility(View.GONE);

                } else {
//                    noresult.setVisibility(View.VISIBLE);
                }
            }
        });
        parkingLogViewModel.getParkingLogViewModel();
//
//        //second
//        RecyclerView recyclerView1 = findViewById(R.id.recycler1);
//        setUpParkLogArrayList2();
//
//        adapter1 = new ParkingLogAdapter(this, parkingLogList2, this);
//        recyclerView1.setAdapter(adapter1);
//        recyclerView1.setLayoutManager(new LinearLayoutManager(this));



//        casuals.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                casuals.setBackgroundColor(getResources().getColor(R.color.transparent));
////                casuals.setTextColor(getResources().getColor(R.color.black));
//                tenants.setBackgroundColor(getResources().getColor(R.color.white));
////                tenants.setTextColor(getResources().getColor(R.color.white));
//                recyclerView.setVisibility(View.VISIBLE);
//                recyclerView1.setVisibility(View.GONE);
//
//            }
//        });

//        tenants.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tenants.setBackgroundColor(getResources().getColor(R.color.transparent));
//                tenants.setTextColor(getResources().getColor(R.color.red));
//                casuals.setBackgroundColor(getResources().getColor(R.color.white));
////                casuals.setTextColor(getResources().getColor(R.color.white));
//                recyclerView.setVisibility(View.GONE);
//                recyclerView1.setVisibility(View.VISIBLE);
//            }
//        });
    }

    private void filterList(String text) {
        ArrayList<ParkingLogModel> filteredList = new ArrayList<>();
        for (ParkingLogModel parkingLogModel : parkingLogList1){
            if (parkingLogModel.getCard().getParkerName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(parkingLogModel);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(this, "No data found....", Toast.LENGTH_SHORT).show();
        }else{
            adapter.setFilteredList(filteredList);
        }
    }
    private void filterRecyclerView(String query) {
        ArrayList<ParkingLogModel> filteredList = new ArrayList<>();

        // Apply filter
        if (mFilterOption.equals("All")) {
            for (ParkingLogModel parkingLogModel : parkingLogList1) {
                if (parkingLogModel.getCard().getParkerName().toLowerCase().contains(query.toLowerCase())) {
     //               filteredList.add(item);
                    filteredList.addAll(parkingLogList1);
                }
            }
        }
//        else if (mFilterOption.equals("Casuals")) {
//            for (ParkingLogModel parkingLogModel : parkingLogList1) {
//                if (parkingLogModel.getParkerName().toLowerCase().contains("Casual".toLowerCase()) && parkingLogModel.getParkerName().toLowerCase().contains(query.toLowerCase())) {
//                    filteredList.add(parkingLogModel);
//                }
//            }
//        } else if (mFilterOption.equals("Tenants")) {
//            for (ParkingLogModel parkingLogModel : parkingLogList1) {
//                if (parkingLogModel.getParkerName().toLowerCase().contains("Shawn".toLowerCase()) && parkingLogModel.getParkerName().toLowerCase().contains(query.toLowerCase())) {
//                    filteredList.add(parkingLogModel);
//                }
//            }
//        }
//
//        // Update RecyclerView adapter
//        adapter.setFilteredList(filteredList);
//        adapter.notifyDataSetChanged();

    }

//    public void clearFilteredData() {
//        parkingLogList1.clear();
//        adapter.notifyDataSetChanged();
//    }


//    private void setUpParkLogArrayList1(){
//
//        String[] cardNumber = getResources().getStringArray(R.array.cardNumber);
//        String[] parkerName = getResources().getStringArray(R.array.propertyMgt_list_propertyName);
//        String[] parkerMobile = getResources().getStringArray(R.array.mobile);
//        String[] parkerTimeIn = getResources().getStringArray(R.array.timeIn);
//        String[] parkerTimeOut = getResources().getStringArray(R.array.timeOut);
//        String[] parkerDuration = getResources().getStringArray(R.array.orderNumber);
//
//        for(int i=0;i<cardNumber.length; i++){
//            parkingLogList1.add(new ParkingLogModel(
//                    cardNumber[i],parkerName[i],parkerMobile[i],parkerTimeIn[i],parkerTimeOut[i],parkerDuration[i]
//            ));
//
//        }
//    };
//    private void setUpParkLogArrayList2(){
//
//        String[] cardNumber = getResources().getStringArray(R.array.cardNumber);
//        String[] parkerName = getResources().getStringArray(R.array.propertyMgt_list_propertyName);
//        String[] parkerMobile = getResources().getStringArray(R.array.mobile);
//        String[] parkerTimeIn = getResources().getStringArray(R.array.timeIn);
//        String[] parkerTimeOut = getResources().getStringArray(R.array.timeOut);
//        String[] parkerDuration = getResources().getStringArray(R.array.orderNumber);
//
//        for(int i=0;i<cardNumber.length; i++){
//            parkingLogList2.add(new ParkingLogModel(
//                    cardNumber[i],parkerName[i],parkerMobile[i],parkerTimeIn[i],parkerTimeOut[i],parkerDuration[i]
//            ));
//
//        }
//    };

    @Override
    public void onItemClick(int position) {
        // Use the original position instead of the position passed from the adapter

        Intent intent = new Intent(ParkingLogActivity.this, ParkinglogItemDescriptionActivity.class);

        intent.putExtra("CARDNUMBER", parkingLogList1.get(position).getCard().getCardNumber());
        intent.putExtra("NAME", parkingLogList1.get(position).getCard().getParkerName());
        intent.putExtra("PARKERMOBILE", parkingLogList1.get(position).getCard().getParkerMobile());
        intent.putExtra("TIMEIN", parkingLogList1.get(position).getParkerTimeIn());
        intent.putExtra("TIMEOUT", parkingLogList1.get(position).getParkerTimeOut());
        intent.putExtra("DURATION", parkingLogList1.get(position).getParkerDuration());
//        adapter.clear();
        startActivity(intent);

    }
    @Override
    public void onOptionClicked(int position, View view) {
        showOptionDialog(position, view);
    }
    private void showOptionDialog(final int position, View view) {
        String[] options = {"Activate", "Suspend"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (which) {
                    case 0:

                        String cardNumber = parkingLogList1.get(position).getCard().getCardNumber();
                        Toast.makeText(ParkingLogActivity.this, cardNumber+" Card Activated", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        // Handle Suspend option
                        String cardNumber1 = parkingLogList1.get(position).getCard().getCardNumber();
                        Toast.makeText(ParkingLogActivity.this, cardNumber1+" Card Suspended", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        builder.show();

    }
}