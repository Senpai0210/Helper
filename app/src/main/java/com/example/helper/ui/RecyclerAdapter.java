package com.example.helper.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helper.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerviewHolder> {

    private static int viewHolderCount;
    private final int numberItems;

    public  RecyclerAdapter(int NumberOfItems){
        numberItems = NumberOfItems;
        viewHolderCount =0;
    }
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        RecyclerviewHolder viewHolder = new RecyclerviewHolder(view);
        viewHolder.ViewHolderIndex.setText("ViewHolder Index " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    static class RecyclerviewHolder extends RecyclerView.ViewHolder {

        TextView ItemList;
        TextView ViewHolderIndex;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            ItemList = itemView.findViewById(R.id.Recycler);
            ViewHolderIndex = itemView.findViewById(R.id.RecyclerViewHolder);
        }

        void bind(int ListIndex) {
            ItemList.setText(String.valueOf(ListIndex));
        }

    }
}

