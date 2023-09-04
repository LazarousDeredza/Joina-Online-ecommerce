package com.joina.joinaonline.SmartParking.Admin.ParkingLog;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.R;
import com.joina.joinaonline.SmartParking.Admin.Adapters.TagManagementAdapter;
import com.joina.joinaonline.model.Category;

import java.util.ArrayList;
import java.util.List;

public class ParkingLogAdapter extends RecyclerView.Adapter<ParkingLogAdapter.MyViewHolder>{

    private final ParkinglogInterface parkinglogInterface;
    Context context;
    ArrayList<ParkingLogModel> parkingLogModelArrayList;

    public void setFilteredList(ArrayList<ParkingLogModel> filteredList){
        this.parkingLogModelArrayList = filteredList;
        notifyDataSetChanged();
    }
    public void setParkingLogModelArrayList(ArrayList<ParkingLogModel> parkingLogModelArrayList) {
        this.parkingLogModelArrayList = parkingLogModelArrayList;
        notifyDataSetChanged();
    }


    public ParkingLogAdapter(Context context, ArrayList<ParkingLogModel> ParkingLogModelArrayList, ParkinglogInterface parkinglogInterface){
        this.context = context;
        this.parkingLogModelArrayList = ParkingLogModelArrayList;
        this.parkinglogInterface = parkinglogInterface;

        // Set the original position of each ParkingLogModel object
//        for (int i = 0; i < ParkingLogModelArrayList.size(); i++) {
//            ParkingLogModelArrayList.get(i).setOriginalPosition(i);
//        }
    }

    @NonNull
    @Override
    public ParkingLogAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout giving the look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.park_log_row, parent, false);
        return new ParkingLogAdapter.MyViewHolder(view, parkinglogInterface, parkingLogModelArrayList);
    }
    @Override
    public void onBindViewHolder(@NonNull ParkingLogAdapter.MyViewHolder holder, int position) {
        //Assigning values to views we created in Row layout file
        //based on position of recycler view
        holder.cardNumber.setText(parkingLogModelArrayList.get(position).getCard().getCardNumber());
        holder.parkerName.setText(parkingLogModelArrayList.get(position).getCard().getParkerName());
        holder.parkerMobile.setText(parkingLogModelArrayList.get(position).getCard().getParkerMobile());
        holder.parkerTimeIn.setText(parkingLogModelArrayList.get(position).getParkerTimeIn());
        holder.parkerTimeOut.setText(parkingLogModelArrayList.get(position).getParkerTimeOut());
        holder.parkerDuration.setText(parkingLogModelArrayList.get(position).getParkerDuration());
    }

    @Override
    public int getItemCount() {
        //How many items you want to display
        if(this.parkingLogModelArrayList != null) {
            return this.parkingLogModelArrayList.size();
        }
        return 0;
    }


    public void clear() {
        parkingLogModelArrayList.clear();
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method

        ImageView moreOptions;
        TextView cardNumber, parkerName, parkerMobile, parkerTimeIn, parkerTimeOut, parkerDuration;
        public MyViewHolder(@NonNull View itemView, ParkinglogInterface parkinglogInterface,ArrayList<ParkingLogModel> parkingLogModelArrayList){
            super(itemView);
            cardNumber = itemView.findViewById(R.id.cardNumber);
            parkerName = itemView.findViewById(R.id.parkerName);
            parkerMobile = itemView.findViewById(R.id.parkerMobile);
            parkerTimeIn = itemView.findViewById(R.id.parkerTimeIn);
            parkerTimeOut = itemView.findViewById(R.id.parkerTimeOut);
            parkerDuration = itemView.findViewById(R.id.parkerDuration);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(parkinglogInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
//                            parkinglogInterface.onItemClick(pos);
                            // Get the original position of the clicked row
                            int originalPos = parkingLogModelArrayList.get(pos).getOriginalPosition();
                            parkinglogInterface.onItemClick(originalPos);
                        }
                    }

                }
            });

            moreOptions = itemView.findViewById(R.id.moreOptions);

            moreOptions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (parkinglogInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            parkinglogInterface.onOptionClicked(position, view);
                        }
                    }
                }
            });
        }
    }


}
