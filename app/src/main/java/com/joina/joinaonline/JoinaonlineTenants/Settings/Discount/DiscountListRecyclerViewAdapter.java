package com.joina.joinaonline.JoinaonlineTenants.Settings.Discount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.R;

import java.util.ArrayList;

public class DiscountListRecyclerViewAdapter extends RecyclerView.Adapter<DiscountListRecyclerViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<DiscountListModelClass> discountListModelClassArrayList;

    public DiscountListRecyclerViewAdapter(Context context, ArrayList<DiscountListModelClass> discountListModelClassArrayList){
        this.context = context;
        this.discountListModelClassArrayList = discountListModelClassArrayList;
    }

    @NonNull
    @Override
    public DiscountListRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout giving the look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.discount_recycler_row, parent, false);
        return new DiscountListRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountListRecyclerViewAdapter.MyViewHolder holder, int position) {
        //Assigning values to views we created in Row layout file
        //based on position of recycler view
        holder.discName.setText(discountListModelClassArrayList.get(position).getDiscName());
        holder.discPercentage.setText(discountListModelClassArrayList.get(position).getDiscPercentage());
        holder.discType.setText(discountListModelClassArrayList.get(position).getDiscType());
        holder.startDate.setText(discountListModelClassArrayList.get(position).getStartDate());
        holder.endDate.setText(discountListModelClassArrayList.get(position).getEndDate());
    }

    @Override
    public int getItemCount() {
        //How many items you want to display
        return discountListModelClassArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method
        TextView discName, discPercentage, discType, startDate, endDate;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            discName = itemView.findViewById(R.id.discName);
            discPercentage = itemView.findViewById(R.id.discPercentage);
            discType = itemView.findViewById(R.id.discType);
            startDate = itemView.findViewById(R.id.startDate);
            endDate = itemView.findViewById(R.id.endDate);
        }
    }




}
