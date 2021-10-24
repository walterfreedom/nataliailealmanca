package com.example.nataliailealmanca;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class customViewHolder extends RecyclerView.ViewHolder {

    public TextView german, turkish;
    public CardView cardView;
    public customViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        german=itemView.findViewById(R.id.textGerman);
        turkish=itemView.findViewById(R.id.textTurkish);
        cardView=itemView.findViewById(R.id.maincontainer);
    }
}
