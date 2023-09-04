package com.joina.joinaonline.Joinaonline.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.Joinaonline.Banking.BankingJOActivity;
import com.joina.joinaonline.Joinaonline.Electronics.ElectronicsJOActivity;
import com.joina.joinaonline.Joinaonline.Entertainment.EntertainmentJOActivity;
import com.joina.joinaonline.Joinaonline.EventsAndBooking.EventsAndBookingJOActivity;
import com.joina.joinaonline.Joinaonline.Fashion.FashionJOActivity;
import com.joina.joinaonline.Joinaonline.FoodandDrink.FoodandDrinkJOActivity;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.BankingListStoresActivity;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.ElectronicsListStoresActivity;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.EntertainmentListStoresActivity;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.EventsAndBookingListStoresActivity;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.FashionListStoresActivity;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.FoodAndDrinkListStoresActivity;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.MedicalListStoresActivity;
import com.joina.joinaonline.Joinaonline.Medical.MedicalJOActivity;
import com.joina.joinaonline.Joinaonline.OrderPayments.ProductCheckoutActivity;
import com.joina.joinaonline.R;

import java.util.List;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.ProductViewHolder> {

    Context context;
    List<VendorResponse> productList;


    public VendorAdapter(Context context, List<VendorResponse> productList) {
        this.context = context;
        this.productList = productList;
    }

    interface  VendorListener {
        void onClick(int position);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.store_list_item, parent, false);



        return new ProductViewHolder(view);
    }

//    StorefrontLayout storefrontLayout = new StorefrontLayout();

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        VendorResponse vendorResponse = productList.get(position);

        holder.imageView.setImageResource(productList.get(position).getImageUrl());
        holder.name.setText(productList.get(position).getProd_name());
        holder.floor.setText(productList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        CardView cardview;
        ImageView imageView;
        TextView name, floor;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.storeLogo);
            name = itemView.findViewById(R.id.storeName);
            floor = itemView.findViewById(R.id.storeAddress);
            cardview = itemView.findViewById(R.id.popular1);
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {
                        try {

                            ((MedicalJOActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}

                        try {

                            ((MedicalListStoresActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}


                        try {

                            ((EntertainmentJOActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}

                        try {

                            ((EntertainmentListStoresActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}


                        try {

                            ((ElectronicsJOActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}

                        try {

                            ((ElectronicsListStoresActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}



                        try {

                            ((BankingJOActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}

                        try {

                            ((BankingListStoresActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}


                        try {

                            ((FoodandDrinkJOActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}

                        try {

                            ((FoodAndDrinkListStoresActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}


                        try {

                            ((FashionJOActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}

                        try {

                            ((FashionListStoresActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}


                        try {

                            ((EventsAndBookingJOActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}

                        try {

                            ((EventsAndBookingListStoresActivity) context).viewDetails(getAdapterPosition());

                        } catch (Exception e) {}
                    }

                    catch (Exception e) {

                    }

                }
            });

        }


    }



}
