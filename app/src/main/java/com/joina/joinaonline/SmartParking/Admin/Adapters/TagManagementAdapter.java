package com.joina.joinaonline.SmartParking.Admin.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.R;
import com.joina.joinaonline.SmartParking.Admin.Interfaces.TagManagementInterface;
import com.joina.joinaonline.SmartParking.Admin.Models.TagManagementModel;
import com.joina.joinaonline.SmartParking.Admin.ParkingLog.ParkingLogModel;


import java.util.ArrayList;

public class TagManagementAdapter extends RecyclerView.Adapter<TagManagementAdapter.MyViewHolder>{

    private final TagManagementInterface tagManagementInterface;
    Context context;
    ArrayList<TagManagementModel> tagManagementModelArrayList;

    public void setFilteredList(ArrayList<TagManagementModel> filteredList){
        this.tagManagementModelArrayList = filteredList;
    }

    public void setTagManagementModelArrayList(ArrayList<TagManagementModel> tagManagementModelArrayList) {
        this.tagManagementModelArrayList = tagManagementModelArrayList;
        notifyDataSetChanged();
    }


    public TagManagementAdapter(Context context, ArrayList<TagManagementModel> tagManagementModelArrayList, TagManagementInterface tagManagementInterface){
        this.context = context;
        this.tagManagementModelArrayList = tagManagementModelArrayList;
        this.tagManagementInterface = tagManagementInterface;
    }

    @NonNull
    @Override
    public TagManagementAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout giving the look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.tag_row, parent, false);
        return new TagManagementAdapter.MyViewHolder(view, tagManagementInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull TagManagementAdapter.MyViewHolder holder, int position) {
        //Assigning values to views we created in Row layout file
        //based on position of recycler view
        holder.cardNumber.setText(tagManagementModelArrayList.get(position).getCardNumber());
        holder.parkerName.setText(tagManagementModelArrayList.get(position).getParkerName());
        holder.parkerMobile.setText(tagManagementModelArrayList.get(position).getParkerMobile());
        holder.cardStatus.setText(tagManagementModelArrayList.get(position).getCardStatus());
        holder.startDate.setText(tagManagementModelArrayList.get(position).getStartDate());
        holder.endDate.setText(tagManagementModelArrayList.get(position).getEndDate());


    }

    @Override
    public int getItemCount() {
        //How many items you want to display

        if(this.tagManagementModelArrayList != null) {
            return this.tagManagementModelArrayList.size();
        }
        return 0;
    }

    public void clear() {
        tagManagementModelArrayList.clear();
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method

        TextView cardNumber, parkerName, parkerMobile, cardStatus,startDate, endDate;
        ImageView moreOptions;
        public MyViewHolder(@NonNull View itemView, TagManagementInterface tagManagementInterface){
            super(itemView);
            cardNumber = itemView.findViewById(R.id.cardNumber);
            parkerName = itemView.findViewById(R.id.parkerName);
            parkerMobile = itemView.findViewById(R.id.parkerMobile);
            cardStatus = itemView.findViewById(R.id.cardStatus);
            startDate = itemView.findViewById(R.id.startDate);
            endDate = itemView.findViewById(R.id.endDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(tagManagementInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            tagManagementInterface.onItemClick(pos, view);
                        }
                    }

                }
            });

            moreOptions = itemView.findViewById(R.id.moreOptions);

            moreOptions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tagManagementInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            tagManagementInterface.onOptionClicked(position, view);
                        }
                    }
                }
            });
        }
    }
}
