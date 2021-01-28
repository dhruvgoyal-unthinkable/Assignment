package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.CustomItemViewBinding;
import com.example.myapplication.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    List<Item> itemList = new ArrayList<>();
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CustomItemViewBinding customItemViewBinding = CustomItemViewBinding.inflate(layoutInflater,parent,false);
        return new ItemViewHolder(customItemViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.customItemViewBinding.setItem(item);
        holder.customItemViewBinding.executePendingBindings();
    }


    public void updateList(List<Item> items){
        this.itemList = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{

        CustomItemViewBinding customItemViewBinding;
        public ItemViewHolder(@NonNull CustomItemViewBinding itemView) {
            super(itemView.getRoot());
            customItemViewBinding = itemView;
        }
    }
}
