package com.joina.joinaonline.Joinaonline.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.Joinaonline.OnClickSingleProductActivity;
import com.joina.joinaonline.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ProductViewHolder> {

    private final Context context;
    private final List<Product> cartList;

    public CartAdapter(Context context, List<Product> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.imageView.setImageResource(cartList.get(position).getImageUrl());
        holder.name.setText(cartList.get(position).getProd_name());
        holder.price.setText(cartList.get(position).getPrice());
        holder.quantity.setText(cartList.get(position).getQuantity());
        holder.brand.setText(cartList.get(position).getBrand());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, price, quantity, brand;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.logo_image);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
            brand = itemView.findViewById(R.id.product_brand);
            quantity = itemView.findViewById(R.id.product_quantity);

        }
    }
}
