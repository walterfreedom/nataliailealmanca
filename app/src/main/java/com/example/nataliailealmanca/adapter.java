package com.example.nataliailealmanca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class adapter extends RecyclerView.Adapter<adapter.viewHolder> {

    String germanData[],turkishData[];
    Context context;
    private OnItemListener monItemListener;

    public adapter(Context ct, String german[], String turkish[],OnItemListener onItemListener){
        context = ct;
        germanData=german;
        turkishData=turkish;
        this.monItemListener=onItemListener;
    }

    @NonNull
    @NotNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.list_items,parent,false);

        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull adapter.viewHolder holder, int position) {
        holder.germanText.setText(germanData[position]);
        holder.turkishText.setText(turkishData[position]);

    }

    @Override
    public int getItemCount() {
        return germanData.length;
    }

    public  class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView germanText,turkishText;
        OnItemListener onItemListener;
        public viewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.onItemListener = onItemListener;

            germanText= itemView.findViewById(R.id.textGerman);
            turkishText=itemView.findViewById(R.id.textTurkish);

        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemListener{
        void onItemClick(int position);
    }
}
