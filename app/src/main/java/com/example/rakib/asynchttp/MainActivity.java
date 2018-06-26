package com.example.rakib.asynchttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.rakib.asynchttp.adapter.ListItemAdapter;
import com.example.rakib.asynchttp.api.ApiClient;

import com.example.rakib.asynchttp.api.ApiServices;
import com.example.rakib.asynchttp.model.Category;
import com.example.rakib.asynchttp.model.CategoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    //Todo: Store the Api key right here
    private final static String API_KEY="7546c1b03b96db7a7aad6f3e05e9ee81";

RecyclerView mRecyclerView;
RecyclerView.LayoutManager mLayoutManager;

ListItemAdapter listItemAdapter;

List<Category> categoryResponseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=findViewById(R.id.list_Recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        loadData();


    }

    private void loadData() {
        ApiServices apiServices= ApiClient.getClient().create(ApiServices.class);

        Call<CategoryResponse> call=apiServices.getCategory();

        call.enqueue(new Callback<CategoryResponse>() {


            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                categoryResponseList=response.body().getCategory();
                Log.d("Tareq","Number of Categories"+categoryResponseList.size());

                listItemAdapter=new ListItemAdapter(MainActivity.this,categoryResponseList);
                mRecyclerView.setAdapter(listItemAdapter);
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().equals("New"))
        {
            Toast.makeText(this, "New Activity is not Added yet from:  "
                    + item.getOrder(), Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
