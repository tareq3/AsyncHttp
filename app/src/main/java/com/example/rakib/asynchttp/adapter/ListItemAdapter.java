package com.example.rakib.asynchttp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rakib.asynchttp.MainActivity;
import com.example.rakib.asynchttp.R;

import java.util.List;

class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener{

    T_ItemClickListener t_itemClickListener;
    TextView name,no_item;

    public ListItemViewHolder(View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.item_name);
        no_item=itemView.findViewById(R.id.item_no);
        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
    }

    public void set_ItemClickListener(T_ItemClickListener itemClickListener){
        this.t_itemClickListener=itemClickListener;
    }

    @Override
    public void onClick(View v) {
        t_itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Select the Action");
        menu.add(0,0,getAdapterPosition(),"DELETE");
    }
}
public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder>{
    MainActivity mainActivity;



    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
