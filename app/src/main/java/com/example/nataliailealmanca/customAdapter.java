package com.example.nataliailealmanca;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class customAdapter extends RecyclerView.Adapter<customViewHolder> {
    private Context context;
    private List<dataModel> list;
    private selectListener listener;

    public customAdapter(Context context, List<dataModel> list,selectListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public customViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        return new customViewHolder(LayoutInflater.from(context).inflate(R.layout.list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull customViewHolder holder, int position) {
        holder.german.setText(list.get(position).getGerman());
        holder.turkish.setText(list.get(position).getTurkish());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
