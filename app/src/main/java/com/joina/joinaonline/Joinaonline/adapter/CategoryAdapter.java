package com.joina.joinaonline.Joinaonline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<Categories> categoriesList;

    public CategoryAdapter(Context context, List<Categories> categoriesList) {
        this.context = context;
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.names_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.name.setText(categoriesList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        MaterialButton name;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_categories);
        }
    }
}
