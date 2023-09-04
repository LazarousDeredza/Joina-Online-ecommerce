package com.joina.joinaonline.Tenants.PropertyManager.PropertyManagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.R;

import java.util.ArrayList;

public class PropertyManagementRecyclerViewAdapter extends RecyclerView.Adapter<PropertyManagementRecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<PropertyManagementModelClass> propertyManagementModelClassArrayList;

    public PropertyManagementRecyclerViewAdapter(Context context, ArrayList<PropertyManagementModelClass> propertyManagementModelClassArrayList){
        this.context = context;
        this.propertyManagementModelClassArrayList = propertyManagementModelClassArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout giving the look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.property_mgt_recycler_row, parent, false);
        return new PropertyManagementRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Assigning values to views we created in Row layout file
        //based on position of recycler view
        holder.tvName.setText(propertyManagementModelClassArrayList.get(position).getPropertyName());
        holder.tvAddress.setText(propertyManagementModelClassArrayList.get(position).getPropertyAddress());
        holder.tvDate.setText(propertyManagementModelClassArrayList.get(position).getPropertyDate());
    }

    @Override
    public int getItemCount() {
        //How many items you want to display
        return propertyManagementModelClassArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method
        TextView tvName, tvAddress, tvDate;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.pMgt_PropertyName);
            tvAddress = itemView.findViewById(R.id.pMgt_PropertyAddress);
            tvDate = itemView.findViewById(R.id.pMgt_PropertyDate);
        }
    }
}





