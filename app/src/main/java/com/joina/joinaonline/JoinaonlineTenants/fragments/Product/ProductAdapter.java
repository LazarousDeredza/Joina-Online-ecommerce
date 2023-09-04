package com.joina.joinaonline.JoinaonlineTenants.fragments.Product;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.Joinaonline.OnClickSingleProductActivity;
import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private final Context context;
    private final List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item_tenant, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.imageView.setImageResource(productList.get(position).getImageUrl());
        holder.name.setText(productList.get(position).getProd_name());
        holder.brand.setText(productList.get(position).getBrand());
        holder.price.setText(productList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, edit, delete;
        TextView name, brand, price;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.logo_image);
            name = itemView.findViewById(R.id.product_name);
            brand = itemView.findViewById(R.id.product_brand);
            price = itemView.findViewById(R.id.product_price);
            delete = itemView.findViewById(R.id.btnDelete);
            edit = itemView.findViewById(R.id.btnEdit);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(context, OnClickSingleProductActivity.class);
//                    context.startActivity(intent);

                    Toast.makeText(context, "Successfully deleted product!", Toast.LENGTH_SHORT).show();
                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(context, OnClickSingleProductActivity.class);
//                    context.startActivity(intent);

                    Toast.makeText(context, "Edit product!", Toast.LENGTH_SHORT).show();
                }
            });



        }
    }
}
