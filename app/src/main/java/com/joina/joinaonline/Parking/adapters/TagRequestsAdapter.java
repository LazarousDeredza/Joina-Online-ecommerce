package com.joina.joinaonline.Parking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.joina.joinaonline.R;

public class TagRequestsAdapter extends RecyclerView.Adapter<TagRequestsAdapter.Holder> {

    private Context context;
    private ArrayList<TagRequests> arrayList;

    public TagRequestsAdapter(Context context, ArrayList<TagRequests> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tag_requests_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        TagRequests tagRequests = arrayList.get(position);
        final String company = tagRequests.getTenant();
        final Integer amount = tagRequests.getAmount();
        final Date date = tagRequests.getDate();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

        /*
         * set view holder text
         * */
        holder.company.setText(company);
        holder.amount.setText(String.valueOf(amount));
        holder.date.setText(format.format(date));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        TextView company, amount, date;

        public Holder(@NonNull View itemView) {
            super(itemView);
            company = itemView.findViewById(R.id.tvTenantCompanyName);
            amount = itemView.findViewById(R.id.totalTagsRequired);
            date = itemView.findViewById(R.id.tvRequestDate);
        }
    }
}
