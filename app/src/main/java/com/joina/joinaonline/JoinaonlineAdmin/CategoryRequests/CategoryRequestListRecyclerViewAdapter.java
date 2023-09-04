package com.joina.joinaonline.JoinaonlineAdmin.CategoryRequests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joina.joinaonline.R;
import com.joina.joinaonline.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRequestListRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRequestListRecyclerViewAdapter.MyViewHolder>{

    private Context context;
    private List<Category> categoryRequestModelClassArrayList;
  //  private final RecyclerViewInterface recyclerViewInterface;


    public CategoryRequestListRecyclerViewAdapter(Context context, List<Category> categoryRequestModelClassArrayList) {
        this.context = context;
        this.categoryRequestModelClassArrayList = categoryRequestModelClassArrayList;
    }

    public void setCategoryRequestModelClassArrayList(List<Category> categoryRequestModelClassArrayList) {
        this.categoryRequestModelClassArrayList = categoryRequestModelClassArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryRequestListRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout giving the look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.category_requests_row, parent, false);
        return new CategoryRequestListRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRequestListRecyclerViewAdapter.MyViewHolder holder, int position) {
        //Assigning values to views we created in Row layout file
        //based on position of recycler view
        holder.categoryName.setText(categoryRequestModelClassArrayList.get(position).getName());
        holder.categoryDescription.setText(categoryRequestModelClassArrayList.get(position).getDescription());
       // holder.tvTitle.setText(this.movieList.get(position).getTitle().toString());

    }

    @Override
    public int getItemCount() {
        //How many items you want to display
        if(this.categoryRequestModelClassArrayList != null) {
            return this.categoryRequestModelClassArrayList.size();
        }
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method
        TextView categoryName, categoryDescription;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryDescription = itemView.findViewById(R.id.categoryDescription);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(recyclerViewInterface != null) {
//                        int pos = getAdapterPosition();
//                        if(pos != RecyclerView.NO_POSITION){
//                            recyclerViewInterface.onItemClick(pos);
//                        }
//                    }
//                }
//            });
        }
    }

}
