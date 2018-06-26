package com.example.rakib.asynchttp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rakib.asynchttp.MainActivity;
import com.example.rakib.asynchttp.R;
import com.example.rakib.asynchttp.model.Category;
import com.example.rakib.asynchttp.model.CategoryResponse;

import java.util.List;
import java.util.zip.Inflater;

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
        menu.add(0,0,getAdapterPosition(),"New");
    }
}
public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder>{
    MainActivity mainActivity;
    List<Category> categoryList;

    public ListItemAdapter(MainActivity mainActivity, List<Category> categoryList) {
        this.mainActivity = mainActivity;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(mainActivity.getBaseContext());
        View view=inflater.inflate(R.layout.recycler_item,parent,false);

        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {

        holder.name.setText(categoryList.get(position).getCName());
        holder.no_item.setText(categoryList.get(position).getNoItem().toString());
        holder.set_ItemClickListener(new T_ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                Toast.makeText(mainActivity.getBaseContext(), "I am no:"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
