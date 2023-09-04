package com.joina.joinaonline.JoinaonlineTenants.Settings.TaxDetails;


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.joina.joinaonline.R;

        import java.util.ArrayList;


public class TaxListRecyclerViewAdapter extends RecyclerView.Adapter<TaxListRecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<TaxListModelClass> taxListModelClassArrayList;

    public TaxListRecyclerViewAdapter(Context context, ArrayList<TaxListModelClass> taxListModelClassArrayList){
        this.context = context;
        this.taxListModelClassArrayList = taxListModelClassArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout giving the look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.tax_details_recycler_row, parent, false);
        return new TaxListRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Assigning values to views we created in Row layout file
        //based on position of recycler view
        holder.taxName.setText(taxListModelClassArrayList.get(position).getTaxName());
        holder.taxDescription.setText(taxListModelClassArrayList.get(position).getTaxDescription());
        holder.taxPercentage.setText(taxListModelClassArrayList.get(position).getTaxPercentage());
    }

    @Override
    public int getItemCount() {
        //How many items you want to display
        return taxListModelClassArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the view from our Row layout file
        //Kinda like in the onCreate method
        TextView taxName, taxDescription, taxPercentage;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            taxName = itemView.findViewById(R.id.taxName);
            taxDescription = itemView.findViewById(R.id.taxDescription);
            taxPercentage = itemView.findViewById(R.id.taxPercentage);
        }
    }
}





