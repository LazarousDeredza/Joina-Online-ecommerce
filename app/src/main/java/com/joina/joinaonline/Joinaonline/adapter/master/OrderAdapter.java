package com.joina.joinaonline.Joinaonline.adapter.master;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.joina.joinaonline.Parking.adapters.TenantsAdapter;
import com.joina.joinaonline.R;
import com.joina.joinaonline.Supplier;
import com.joina.joinaonline.model.master.Order;
import com.joina.joinaonline.util.localstorage.LocalStorage;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    List<Order> orderList;
    Context context;
    int pQuantity = 1;
    String _subtotal, _price, _quantity;
    LocalStorage localStorage;
    Gson gson;

    public OrderAdapter(List<Order> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_order, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        final Order order = orderList.get(position);
        holder.orderId.setText(order.getOrderId());
        holder.date.setText(order.getDate());
        holder.total.setText(order.getTotal());
        holder.status.setText(order.getStatus());

        List<Supplier> suppliers=order.getSuppliers();

        for (Supplier s:suppliers             ) {
            holder.supplierName.setText(holder.supplierName.getText().toString().trim()+"\n"+
            s.getName());

            holder.supplierTotal.setText(holder.supplierTotal.getText().toString().trim()+"\n"+
                    "$ "+s.getTotalPrice());

        }



    }

    @Override
    public int getItemCount() {

        return orderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView orderId, date, total, status, supplierName, supplierTotal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            orderId = itemView.findViewById(R.id.order_id);
            date = itemView.findViewById(R.id.date);
            total = itemView.findViewById(R.id.total_amount);
            status = itemView.findViewById(R.id.status);
            supplierName = itemView.findViewById(R.id.supplierName);
            supplierTotal = itemView.findViewById(R.id.supplierTotal);

        }
    }
}
