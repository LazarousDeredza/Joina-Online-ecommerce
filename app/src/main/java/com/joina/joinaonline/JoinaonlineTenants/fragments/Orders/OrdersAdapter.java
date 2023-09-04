package com.joina.joinaonline.JoinaonlineTenants.fragments.Orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.JoinaonlineAdmin.CategoryRequests.CategoryRequestListRecyclerViewAdapter;
import com.joina.joinaonline.JoinaonlineAdmin.CategoryRequests.CategoryRequestModelClass;
import com.joina.joinaonline.R;

import java.util.ArrayList;


public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder>{

    Context context;
    ArrayList<OrdersModelClass> ordersModelClassArrayList;
    //  private final RecyclerViewInterface recyclerViewInterface;

    public OrdersAdapter(Context context, ArrayList<OrdersModelClass> ordersModelClassArrayList){
        this.context = context;
        this.ordersModelClassArrayList = ordersModelClassArrayList;
        //this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public OrdersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout giving the look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.orders_tenant_row, parent, false);
        return new OrdersAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersAdapter.MyViewHolder holder, int position) {
        //Assigning values to views we created in Row layout file
        //based on position of recycler view

        holder.orderNumber.setText(ordersModelClassArrayList.get(position).getOrderNumber());
        holder.userName.setText(ordersModelClassArrayList.get(position).getUserName());
        holder.totalPrice.setText(ordersModelClassArrayList.get(position).getTotalPrice());
        holder.status.setText(ordersModelClassArrayList.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        //How many items you want to display
        return ordersModelClassArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method
        TextView orderNumber, userName, totalPrice, status,id;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            orderNumber = itemView.findViewById(R.id.orderNumber);
            userName = itemView.findViewById(R.id.userName);
            totalPrice = itemView.findViewById(R.id.totalPrice);
            status = itemView.findViewById(R.id.status);

        }
    }

}
