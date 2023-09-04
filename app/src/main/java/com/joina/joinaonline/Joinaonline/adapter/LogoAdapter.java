package com.joina.joinaonline.Joinaonline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.Joinaonline.Interfaces.LogoInterface;
import com.joina.joinaonline.R;
import com.joina.joinaonline.SmartParking.Admin.ParkingLog.ParkingLogModel;
import com.joina.joinaonline.SmartParking.Admin.ParkingLog.ParkinglogInterface;

import java.util.ArrayList;
import java.util.List;

public class LogoAdapter extends RecyclerView.Adapter<LogoAdapter.LogoViewHolder> {
    private final LogoInterface logoInterface;
    Context context;
    List<Logo> logoList;
    public void setFilteredList(List<Logo> filteredList){
        this.logoList = filteredList;
        notifyDataSetChanged();
    }
//    public void setParkingLogModelArrayList(ArrayList<ParkingLogModel> parkingLogModelArrayList) {
//        this.parkingLogModelArrayList = parkingLogModelArrayList;
//        notifyDataSetChanged();
//    }
    public LogoAdapter(Context context, List<Logo> logoList, LogoInterface logoInterface) {
        this.context = context;
        this.logoList = logoList;
        this.logoInterface = logoInterface;
    }

    @NonNull
    @Override
    public LogoAdapter.LogoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.logo_item, parent, false);
        return new LogoAdapter.LogoViewHolder(view, logoInterface, logoList);
    }
    @Override
    public void onBindViewHolder(@NonNull LogoAdapter.LogoViewHolder holder, int position) {
        //Assigning values to views we created in Row layout file
        //based on position of recycler view
        holder.shopLogo.setImageResource(logoList.get(position).getImageUrl());
    }
    @Override
    public int getItemCount() {

        //How many items you want to display
        if(this.logoList != null) {
            return this.logoList.size();
        }
        return 0;
    }

    public void clear() {
        logoList.clear();
        notifyDataSetChanged();
    }

    public class LogoViewHolder extends RecyclerView.ViewHolder {
        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method
        ImageView shopLogo;

        public LogoViewHolder(@NonNull View itemView, LogoInterface logoInterface,List<Logo> logoList) {
            super(itemView);
            shopLogo = itemView.findViewById(R.id.shop_logo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(logoInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            logoInterface.onItemClick(pos, view);
                            // Get the original position of the clicked row
//                            int originalPos = logoList.get(pos).getOriginalPosition();
//                            parkinglogInterface.onItemClick(originalPos);
                        }
                    }

                }
            });
        }
    }
}
