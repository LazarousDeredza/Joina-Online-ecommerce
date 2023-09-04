package com.joina.joinaonline;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

import com.joina.joinaonline.Joinaonline.Groceries.GroceriesJOActivity;
import com.joina.joinaonline.Joinaonline.OnClickSingleProductActivity;
import com.joina.joinaonline.R;
import com.joina.joinaonline.model.Category;
import com.joina.joinaonline.model.ProductDto;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter2 extends RecyclerView.Adapter<ProductAdapter2.ProductViewHolder> {

    private  Context context;
    private  List<ProductDto> productList;


    public ProductAdapter2(Context context, List<ProductDto> productList) {
        this.context = context;
        this.productList = productList;
    }

    public void setProductList(List<ProductDto> newProductList) {
        this.productList = newProductList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        Toast.makeText(view.getContext(), "WINNIE ! This is a test toast!",Toast.LENGTH_SHORT).show();
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        String url= productList.get(position).getImage1();

        Picasso.get().load(url).into(holder.imageView);
        holder.name.setText(productList.get(position).getName());
        holder.price.setText(Double.toString(productList.get(position).getUnit_price()));
    }

    @Override
    public int getItemCount() {

        if(this.productList != null) {
            return productList.size();
        }
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        CardView cardview;
        TextView name, price;
        CardView cart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.logo_image);
            name = itemView.findViewById(R.id.name4);
            price = itemView.findViewById(R.id.price);
            cardview = itemView.findViewById(R.id.popular4);
            cart = itemView.findViewById(R.id.cart);

            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(context, OnClickSingleProductActivity.class);
//                    context.startActivity(intent);

                    Toast.makeText(context, "Successfully added to cart !", Toast.LENGTH_SHORT).show();
                }
            });

            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context, OnClickSingleProductActivity.class);
                    context.startActivity(intent);
                }
            });

        }
    }}
