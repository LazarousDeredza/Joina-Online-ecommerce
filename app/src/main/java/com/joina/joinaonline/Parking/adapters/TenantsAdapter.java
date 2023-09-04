package com.joina.joinaonline.Parking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.joina.joinaonline.R;

public class TenantsAdapter extends RecyclerView.Adapter<TenantsAdapter.Holder> {

    private Context context;
    private ArrayList<Tenants> arrayList;

    public TenantsAdapter(Context context, ArrayList<Tenants> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.client_prifile_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Tenants tenants = arrayList.get(position);
        final String name = tenants.getName();
        final Integer floor = tenants.getFloor();
        final Integer employees = tenants.getEmployees();

        /*
         * set view holder text
         * */
        holder.tenantName.setText(name);
        holder.tenantFloor.setText(String.valueOf(floor));
        holder.totalEmployees.setText(String.valueOf(employees));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        TextView tenantName, tenantFloor, totalEmployees;

        public Holder(@NonNull View itemView) {
            super(itemView);

            tenantName = itemView.findViewById(R.id.tvTenantName);
            tenantFloor = itemView.findViewById(R.id.tvTenantFloorNumber);
            totalEmployees = itemView.findViewById(R.id.totalEmployees);
        }
    }
}
