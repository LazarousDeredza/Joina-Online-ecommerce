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
import com.joina.joinaonline.SmartParking.Admin.Interfaces.UsersInterface;
import com.joina.joinaonline.SmartParking.Admin.Models.TagManagementModel;
import com.joina.joinaonline.SmartParking.Admin.Models.UsersModel;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder>{
    private final UsersInterface usersInterface;
    Context context;
    ArrayList<UsersModel> usersModelArrayList;

    public void setFilteredList(ArrayList<UsersModel> filteredList){
        this.usersModelArrayList = filteredList;
    }

    public UsersAdapter(Context context, ArrayList<UsersModel> usersModelArrayList, UsersInterface usersInterface){
        this.context = context;
        this.usersModelArrayList = usersModelArrayList;
        this.usersInterface = usersInterface;
    }

    @NonNull
    @Override
    public UsersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout giving the look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.users_row, parent, false);
        return new UsersAdapter.MyViewHolder(view, usersInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.MyViewHolder holder, int position) {
        //Assigning values to views we created in Row layout file
        //based on position of recycler view
        holder.cardNumber.setText(usersModelArrayList.get(position).getCardNumber());
        holder.parkerName.setText(usersModelArrayList.get(position).getParkerName());
        holder.parkerMobile.setText(usersModelArrayList.get(position).getParkerMobile());
        holder.cardStatus.setText(usersModelArrayList.get(position).getCardStatus());
        holder.startDate.setText(usersModelArrayList.get(position).getStartDate());
        holder.endDate.setText(usersModelArrayList.get(position).getEndDate());


    }

    @Override
    public int getItemCount() {
        //How many items you want to display
        return usersModelArrayList.size();
    }

    public void clear() {
        usersModelArrayList.clear();
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method

        TextView cardNumber, parkerName, parkerMobile, cardStatus,startDate, endDate;
        ImageView moreOptions;
        public MyViewHolder(@NonNull View itemView, UsersInterface usersInterface){
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
                    if(usersInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            usersInterface.onItemClick(pos, view);
                        }
                    }

                }
            });

            moreOptions = itemView.findViewById(R.id.moreOptions);

            moreOptions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (usersInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            usersInterface.onOptionClicked(position, view);
                        }
                    }
                }
            });
        }
    }
}
