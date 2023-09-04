package com.joina.joinaonline.SmartParking.Admin.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.R;
import com.joina.joinaonline.SmartParking.Admin.Interfaces.PaymentInterface;
import com.joina.joinaonline.SmartParking.Admin.Interfaces.TagManagementInterface;
import com.joina.joinaonline.SmartParking.Admin.Models.PaymentModel;
import com.joina.joinaonline.SmartParking.Admin.Models.TagManagementModel;

import java.util.ArrayList;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.MyViewHolder> {

    private final PaymentInterface paymentInterface;
    Context context;
    ArrayList<PaymentModel> paymentModelArrayList;

    public void setFilteredList(ArrayList<PaymentModel> filteredList){
        this.paymentModelArrayList = filteredList;
    }

    public PaymentAdapter(Context context, ArrayList<PaymentModel> paymentModelArrayList, PaymentInterface paymentInterface){
        this.context = context;
        this.paymentModelArrayList = paymentModelArrayList;
        this.paymentInterface = paymentInterface;
    }

    @NonNull
    @Override
    public PaymentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout giving the look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.payment_row, parent, false);
        return new PaymentAdapter.MyViewHolder(view, paymentInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentAdapter.MyViewHolder holder, int position) {
        //Assigning values to views we created in Row layout file
        //based on position of recycler view
        holder.cardNumber.setText(paymentModelArrayList.get(position).getCardNumber());
        holder.amount.setText(paymentModelArrayList.get(position).getAmount());
        holder.paymentMethod.setText(paymentModelArrayList.get(position).getPaymentMethod());
        holder.payTime.setText(paymentModelArrayList.get(position).getPayTime());

    }

    @Override
    public int getItemCount() {
        //How many items you want to display
        return paymentModelArrayList.size();
    }

    public void clear() {
        paymentModelArrayList.clear();
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method

        TextView cardNumber, amount, paymentMethod, payTime;
        ImageView moreOptions;

        public MyViewHolder(@NonNull View itemView, PaymentInterface paymentInterface){
            super(itemView);

            cardNumber = itemView.findViewById(R.id.cardNumber);
            amount = itemView.findViewById(R.id.amount);
            paymentMethod = itemView.findViewById(R.id.paymentMethod);
            payTime = itemView.findViewById(R.id.payTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(paymentInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            paymentInterface.onItemClick(pos, view);
                        }
                    }

                }
            });

            moreOptions = itemView.findViewById(R.id.moreOptions);

            moreOptions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (paymentInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            paymentInterface.onOptionClicked(position, view);
                        }
                    }
                }
            });
        }
    }
}
