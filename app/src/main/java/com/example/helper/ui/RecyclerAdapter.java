package com.example.helper.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helper.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerviewHolder> {

    private final int numberItems;
    public String[] LT;
    private Context fragment;

    public RecyclerAdapter(String[] list, Context fragment) {
        numberItems = list.length;
        LT = list;
        this.fragment = fragment;
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

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int viewHolderCount) {
        holder.bind(viewHolderCount);
    }


    @Override
    public int getItemCount() {
        return numberItems;
    }

    class RecyclerviewHolder extends RecyclerView.ViewHolder {

        TextView ItemList;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            ItemList = itemView.findViewById(R.id.Recycler);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.listItemFragment);
                }
            });
        }

        void bind(int ListIndex) {
            ItemList.setText(LT[ListIndex]);
        }

    }
}

