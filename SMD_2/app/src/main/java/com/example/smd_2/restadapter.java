package com.example.smd_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class restadapter extends RecyclerView.Adapter<restadapter.ViewHolder> {

    ArrayList<rest> rests;
    ArrayList<rest> filtrest;
    public restadapter(ArrayList<rest> list)
    {
        this.rests = list;
        this.filtrest = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rest, parent, false);
        return new ViewHolder(v);
    }

    public void filter(String query) {
        filtrest.clear();
        if (query.isEmpty()) {
            filtrest.addAll(rests); // Show all items if query is empty
        } else {
            query = query.toLowerCase(Locale.getDefault());
            for (rest item : rests) {
                // Check if any value in the item matches the query
                if (item.getName().toLowerCase(Locale.getDefault()).contains(query)
                        || item.getLocation().toLowerCase(Locale.getDefault()).contains(query)
                        || item.getNumber().toLowerCase(Locale.getDefault()).contains(query)
                        || item.getDecription().toLowerCase(Locale.getDefault()).contains(query)
                        || item.getRating().toLowerCase(Locale.getDefault()).contains(query)) {
                    filtrest.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvrating.setText(rests.get(position).getRating());
        holder.tvname.setText(rests.get(position).getName());
        holder.tvlocation.setText(rests.get(position).getLocation());
        holder.tvnumber.setText(rests.get(position).getNumber());
        holder.tvdesc.setText(rests.get(position).getDecription());
    }

    @Override
    public int getItemCount() {
        return rests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvrating,tvname, tvlocation, tvnumber, tvdesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvrating = itemView.findViewById(R.id.tvrating);
            tvname = itemView.findViewById(R.id.tvname);
            tvlocation = itemView.findViewById(R.id.tvlocation);
            tvnumber = itemView.findViewById(R.id.tvnumber);
            tvdesc = itemView.findViewById(R.id.tvdesc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), tvrating.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

