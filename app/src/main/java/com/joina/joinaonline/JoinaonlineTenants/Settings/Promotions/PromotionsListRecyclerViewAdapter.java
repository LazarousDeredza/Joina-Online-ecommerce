package com.joina.joinaonline.JoinaonlineTenants.Settings.Promotions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.JoinaonlineTenants.Settings.Promotions.PromotionsListModelClass;
import com.joina.joinaonline.JoinaonlineTenants.Settings.Promotions.PromotionsListRecyclerViewAdapter;
import com.joina.joinaonline.R;

import java.util.ArrayList;

public class PromotionsListRecyclerViewAdapter extends RecyclerView.Adapter<PromotionsListRecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<PromotionsListModelClass> promotionsListModelClassArrayList;

    public PromotionsListRecyclerViewAdapter(Context context, ArrayList<PromotionsListModelClass> promotionsListModelClassArrayList) {
        this.context = context;
        this.promotionsListModelClassArrayList = promotionsListModelClassArrayList;
    }

    @NonNull
    @Override
    public PromotionsListRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout giving the look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.promotion_recycler_row, parent, false);
        return new PromotionsListRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionsListRecyclerViewAdapter.MyViewHolder holder, int position) {
        //Assigning values to views we created in Row layout file
        //based on position of recycler view
        holder.promotionName.setText(promotionsListModelClassArrayList.get(position).getPromotionName());
        holder.promotionPercentage.setText(promotionsListModelClassArrayList.get(position).getPromotionPercentage());
        holder.promotionStatus.setText(promotionsListModelClassArrayList.get(position).getPromotionStatus());
        holder.promoStartDate.setText(promotionsListModelClassArrayList.get(position).getPromoStartDate());
        holder.promoEndDate.setText(promotionsListModelClassArrayList.get(position).getPromoEndDate());
    }

    @Override
    public int getItemCount() {
        //How many items you want to display
        return promotionsListModelClassArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method
        TextView promotionName, promotionPercentage, promotionStatus, promoStartDate, promoEndDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            promotionName = itemView.findViewById(R.id.promotionName);
            promotionPercentage = itemView.findViewById(R.id.promotionPercentage);
            promotionStatus = itemView.findViewById(R.id.promotionStatus);
            promoStartDate = itemView.findViewById(R.id.promoStartDate);
            promoEndDate = itemView.findViewById(R.id.promoEndDate);
        }

    }
}

