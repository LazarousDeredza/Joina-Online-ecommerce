package com.joina.joinaonline.JoinaonlineAdmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.R;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyHolder>{

  Context context;
  ArrayList<LinearPojo> arrayList;

  public AdapterRecycler(Context context,ArrayList<LinearPojo> arrayList){
    this.context = context;
    this.arrayList = arrayList;
  }
  @NonNull
  @Override
  public AdapterRecycler.MyHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
    View view = LayoutInflater.from(context).inflate(R.layout.tenant_profile_item,parent,false);
    MyHolder myHolder = new MyHolder(view);
    return myHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull AdapterRecycler.MyHolder holder, int position) {
    holder.tvTenantName.setText(arrayList.get(position).getTenantName());
    holder.tvTenantShopDescription.setText(arrayList.get(position).getTvTenantShopDescription());
    holder.tvTenantFloorNumber.setText(arrayList.get(position).getTvTenantFloorNumber());
  }

  @Override
  public int getItemCount() {
    return arrayList.size();
  }

  public static class MyHolder extends RecyclerView.ViewHolder {
    TextView tvTenantName,tvTenantShopDescription,tvTenantFloorNumber;
    public MyHolder(@NonNull View view){
      super(view);
      tvTenantName = view.findViewById(R.id.tvTenantName);
      tvTenantShopDescription = view.findViewById(R.id.tvTenantShopDescription);
      tvTenantFloorNumber = view.findViewById(R.id.tvTenantFloorNumber);
    }
  }

}
