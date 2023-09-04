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
import com.joina.joinaonline.SmartParking.Admin.Adapters.PaymentAdapter;
import com.joina.joinaonline.SmartParking.Admin.Adapters.TagManagementAdapter;
import com.joina.joinaonline.SmartParking.Admin.Interfaces.PaymentInterface;
import com.joina.joinaonline.SmartParking.Admin.Models.PaymentModel;
import com.joina.joinaonline.SmartParking.Admin.Models.TagManagementModel;

import java.util.ArrayList;


public class SPPaymentsFragment extends Fragment implements PaymentInterface {

    PaymentAdapter adapter;
    ArrayList<PaymentModel> paymentModelArrayList = new ArrayList<>();
    private NavController navController;

    ImageView search;
    SearchView searchView;

    public SPPaymentsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_s_p_payments, container, false);


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
        setUpPaymentArrayList();

        adapter = new PaymentAdapter(requireContext(), paymentModelArrayList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        // Call the notifyDataSetChanged() method on the adapter
//        adapter.notifyDataSetChanged();

        return  view;
    }

    private void filterList(String text) {
        ArrayList<PaymentModel> filteredList = new ArrayList<>();
        for (PaymentModel paymentModel : paymentModelArrayList){
            if (paymentModel.getCardNumber().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(paymentModel);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(requireContext(), "No data found....", Toast.LENGTH_SHORT).show();
        }else{
            adapter.setFilteredList(filteredList);
        }
    }

    private void setUpPaymentArrayList(){



        String[] cardNumber = getResources().getStringArray(R.array.cardNumber);
        String[] amount = getResources().getStringArray(R.array.amount);
        String[] paymentMethod = getResources().getStringArray(R.array.paymentMethod);
        String[] payTime = getResources().getStringArray(R.array.startDatee);

        paymentModelArrayList.clear();
        for(int i=0;i<cardNumber.length; i++){
            paymentModelArrayList.add(new PaymentModel(
                    cardNumber[i],amount[i],paymentMethod[i],payTime[i]
            ));

        }
    };

    @Override
    public void onItemClick(int position, View view) {

        String cardNumber = paymentModelArrayList.get(position).getCardNumber();
        navController = Navigation.findNavController(view);
        if (cardNumber != null) {
            Bundle bundle = new Bundle();
            bundle.putString("cardNumber", cardNumber);
            navController.navigate(R.id.action_SPPaymentsFragment_to_paymentDetailsFragment, bundle);
            adapter.clear();
        }


    }

    @Override
    public void onOptionClicked(int position, View view) {
        showOptionDialog(position, view);
    }
    private void showOptionDialog(final int position, View view) {
        String[] options = {"View", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(options, new DialogInterface.OnClickListener() {
            NavController navController= Navigation.findNavController(view);
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (which) {
                    case 0:

                        String cardNumber = paymentModelArrayList.get(position).getCardNumber();
                        Toast.makeText(getContext(), cardNumber+" View Opened", Toast.LENGTH_SHORT).show();
//                        paymentModelArrayList.get(position).setCardStatus("Active");

                        // Notify the adapter of the data changes
                        adapter.notifyDataSetChanged();

//                        // Update the data in your adapter (for example, by retrieving new data from a database)
//                        ArrayList<TagManagementModel> newData = getDataFromDatabase();
//                        adapter.setData(newData);
//                          navController.navigate(R.id.action_SPTagManagenentFragment_self);

                        break;
                    case 1:
                        // Handle Suspend option
                        String cardNumber1 = paymentModelArrayList.get(position).getCardNumber();
                        Toast.makeText(getContext(), cardNumber1+" deleted", Toast.LENGTH_SHORT).show();
//                        tagManagementModelArrayList.get(position).setCardStatus("Suspended");
//                        navController.navigate(R.id.action_SPTagManagenentFragment_self);
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });
        builder.show();
    }
}