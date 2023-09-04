package com.joina.joinaonline.Joinaonline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.R;

import java.util.List;

public class CheckoutProductAdapter extends RecyclerView.Adapter<CheckoutProductAdapter.CheckoutViewHolder> {

    private final Context context;
    private final List<Product> checkoutProductList;

    public CheckoutProductAdapter(Context context, List<Product> checkoutProductList) {
        this.context = context;
        this.checkoutProductList = checkoutProductList;
    }

    @NonNull
    @Override
    public CheckoutProductAdapter.CheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.checkout_item, parent, false);
        return new CheckoutProductAdapter.CheckoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutProductAdapter.CheckoutViewHolder holder, int position) {

        holder.imageView.setImageResource(checkoutProductList.get(position).getImageUrl());
        holder.name.setText(checkoutProductList.get(position).getProd_name());
        holder.price.setText(checkoutProductList.get(position).getPrice());
        holder.brand.setText(checkoutProductList.get(position).getBrand());
    }

    @Override
    public int getItemCount() {
        return checkoutProductList.size();
    }

    public class CheckoutViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, price, brand;

        public CheckoutViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.logo_image);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
            brand = itemView.findViewById(R.id.product_brand);

        }
    }

}
