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
import com.joina.joinaonline.JoinaonlineAdmin.CategoryRequests.CategoryRequestListRecyclerViewAdapter;
import com.joina.joinaonline.R;
import com.joina.joinaonline.model.Category;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private  Context context;
    private  List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_item, parent, false);
        return new ProductAdapter.ProductViewHolder(view);

        //inflate the layout giving the look to our rows
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.category_requests_row, parent, false);
//        return new CategoryRequestListRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        //Assigning values to views we created in Row layout file
        //based on position of recycler view

        holder.imageView.setImageResource(productList.get(position).getImageUrl());
        holder.name.setText(productList.get(position).getProd_name());
        holder.price.setText(productList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        //How many items you want to display
        if(this.productList != null) {
            return this.productList.size();
        }
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method

        ImageView imageView;
        CardView cardview;
        TextView name, price;
        CardView cart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

//            imageView = itemView.findViewById(R.id.logo_image);
//            Picasso.get().load("http://165.22.126.3:4100/media/"+imageView).into(imageView);


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

//                    if (context.getApplicationContext() ==  Activity) {
////                        ((MedicalJOActivity) context).viewDetails(getAdapterPosition());
//                        Toast.makeText(context.getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        Toast.makeText(context.getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
//                    }

//                    try {
////                        ((MedicalJOActivity) context).viewDetails(getAdapterPosition());
////                        ((FoodandDrinkJOActivity) context).viewDetails(getAdapterPosition());
//
//                    }
//                    catch (Exception e) {
//                        Toast.makeText(context.getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
//                    }

//                    ((MedicalJOActivity) context).viewDetails(getAdapterPosition()) || ((FashionJOActivity) context).viewDetails(getAdapterPosition());
//                    context.getApplicationContext().viewDetails(getAdapterPosition());
//                    ((FoodandDrinkJOActivity) context).viewDetails(getAdapterPosition());
//                    ((BankingJOActivity) context).viewDetails(getAdapterPosition());
//                    ((GroceriesJOActivity) context).viewDetails(getAdapterPosition());
//                    ((EntertainmentJOActivity) context).viewDetails(getAdapterPosition());
//                    ((EventsAndBookingJOActivity) context).viewDetails(getAdapterPosition());
//                    ((Elec) context).viewDetails(getAdapterPosition());
                }
            });

    }
}}
