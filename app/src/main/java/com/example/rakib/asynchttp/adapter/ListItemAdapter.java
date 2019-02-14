package com.example.rakib.asynchttp.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rakib.asynchttp.R;
import com.example.rakib.asynchttp.model.Category;
import com.example.rakib.asynchttp.model.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemViewHolder>{

    private ItemClickListener mItemClickListener; /*Interface for item click callback*/

    /*View Holder Class*/
    class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener{


    TextView name,no_item; /*Views */

    /* Constructor*/
    ListItemViewHolder(View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.item_name);
        no_item=itemView.findViewById(R.id.item_no);

        itemView.setOnClickListener(this); /*for single click listener*/
        itemView.setOnCreateContextMenuListener(this);/*for long press listener*/
    }

    /*passing item click callback from view to interface ItemClickListener */
    @Override
    public void onClick(View v) {
        /*if listener available */
        if(mItemClickListener!=null)    mItemClickListener.onClick(v,getAdapterPosition(),false);
    }

    /* for long press */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Select the Action");
        menu.add(0,0,getAdapterPosition(),"New");
    }
}
/*End of ViewHolder Class*/

   /*Member variables of adapter class */
    Activity mActivity; /* */
    List<Category> categoryList;

    /*Constructor with click listener*/
    public ListItemAdapter(Activity mActivity, List<Category> categoryList, ItemClickListener itemClickListener) {
        this.mActivity = mActivity;
        this.categoryList = categoryList;
        this.mItemClickListener=itemClickListener;
    }


    /* for updating adapter on refresh*/
    public void updateAdapter(ArrayList<Category> list){
        categoryList=  list;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(mActivity.getBaseContext());
        View view=inflater.inflate(R.layout.recycler_item,parent,false);

        return new ListItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {

        holder.name.setText(categoryList.get(position).getCName());
        holder.no_item.setText(categoryList.get(position).getNoItem().toString());

        //Another way not recommended to handle item click
      /*  holder.seItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                Toast.makeText(mActivity.getBaseContext(), "I am no:"+position, Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    /* Interface for Item click callback */
    public interface ItemClickListener {

        void onClick(View view, int position, boolean isLongClick);
    }

}
