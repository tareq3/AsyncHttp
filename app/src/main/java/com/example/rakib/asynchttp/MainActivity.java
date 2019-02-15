package com.example.rakib.asynchttp;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.rakib.asynchttp.adapter.ListItemAdapter;


public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, ListItemAdapter.ItemClickListener, MainActivity_RecyclerFragment.OnDataSetChangedListener {

    //Todo: Store the Api key right here
    private final static String API_KEY = "7546c1b03b96db7a7aad6f3e05e9ee81";


    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeRefreshLayout = findViewById(R.id.swiperefresh);

        // BEGIN_INCLUDE (change_colors)
        // Set the color scheme of the SwipeRefreshLayout by providing 4 color resource ids
        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.swipe_color_1, R.color.swipe_color_2,
                R.color.swipe_color_3, R.color.swipe_color_4);
        // END_INCLUDE (change_colors)

        mSwipeRefreshLayout.setOnRefreshListener(this);


        initRecyclerViewFragment(savedInstanceState);


    }

    MainActivity_RecyclerFragment fragmentInstance;

    private void initRecyclerViewFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            fragmentInstance = MainActivity_RecyclerFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main_recyclerview_container, fragmentInstance)
                    .commitNow();
        }
    }


    /*On long press context*/
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle().equals("New")) {
            Toast.makeText(this, "New Activity is not Added yet from:  "
                    + item.getOrder(), Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    /*on pull refresh update the adapter*/
    @Override
    public void onRefresh() {

        Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();

        /*Calling a fragment method in activity don't use interface for this reason*/
        fragmentInstance.loadData();
    }

    /*On Item click*/
    @Override
    public void onClick(View view, int position, boolean isLongClick) {
        Toast.makeText(this, "pos: " + position, Toast.LENGTH_SHORT).show();
    }

    /*On Recycler view updated*/
    @Override
    public void onDataUpdate(boolean completed) {
        Toast.makeText(this, "Called", Toast.LENGTH_SHORT).show();
        if (completed) mSwipeRefreshLayout.setRefreshing(false);
    }


}
