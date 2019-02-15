package com.example.rakib.asynchttp;

import android.content.Context;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rakib.asynchttp.adapter.ListItemAdapter;
import com.example.rakib.asynchttp.api.ApiClient;
import com.example.rakib.asynchttp.api.ApiServices;
import com.example.rakib.asynchttp.model.Category;
import com.example.rakib.asynchttp.model.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * <p>
 * interaction events. Use the {@link MainActivity_RecyclerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivity_RecyclerFragment extends Fragment {

    RecyclerView mRecyclerView;


    ListItemAdapter listItemAdapter;

    List<Category> categoryResponseList = new ArrayList<>();
    Context mContext;


    private OnDataSetChangedListener mOnDataSetChangedListener;

    public MainActivity_RecyclerFragment() {
        // Required empty public constructor
    }


    public static MainActivity_RecyclerFragment newInstance() {
        MainActivity_RecyclerFragment fragment = new MainActivity_RecyclerFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_main_body_recyclerview_fragment, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (context instanceof OnDataSetChangedListener) {

            mOnDataSetChangedListener = (OnDataSetChangedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDataSetChangedListener");
        }


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = getView().findViewById(R.id.list_Recycler);

        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManagerRecyler = new LinearLayoutManager(getView().getContext());
        mRecyclerView.setLayoutManager(layoutManagerRecyler);

        listItemAdapter = new ListItemAdapter(mContext, categoryResponseList, null); //if we don't need to use listener can use null instead of this

        mRecyclerView.setAdapter(listItemAdapter);

        loadData();
    }

    /*for loading data using retrofit*/
    public void loadData() {
        ApiServices apiServices = ApiClient.getClient().create(ApiServices.class);

        Call<CategoryResponse> call = apiServices.getCategory();

        call.enqueue(new Callback<CategoryResponse>() {


            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                categoryResponseList = response.body().getCategory();
                Log.d("Tareq", "Number of Categories" + categoryResponseList.size());

                listItemAdapter.updateAdapter((ArrayList<Category>) categoryResponseList);


                listItemAdapter.notifyDataSetChanged();

                //Notify Data updated on Activity
                mOnDataSetChangedListener.onDataUpdate(true);

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOnDataSetChangedListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this fragment to allow an
     * interaction in this fragment to be communicated to the activity and potentially other
     * fragments contained in that activity.
     * <p>
     * See the Android Training lesson <a href= "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnDataSetChangedListener {
        void onDataUpdate(boolean completed);
    }
}
