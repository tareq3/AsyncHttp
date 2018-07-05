package com.example.rakib.asynchttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.rakib.asynchttp.AsyncTaskHost.JsonDataFactory;
import com.example.rakib.asynchttp.Models.Categories_DataModel;
import com.example.rakib.asynchttp.AsyncTaskHost.JsonHttpTask;
import com.example.rakib.asynchttp.AsyncTaskHost.JsonHttpTaskCompleteListener;
import com.example.rakib.asynchttp.Models.WishesDataModel;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements JsonHttpTaskCompleteListener {

    JsonHttpTask mJsonHttptask;

    HashMap<String, Object> params=new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    mJsonHttptask=new JsonHttpTask(this);


        // mJsonHttptask.executeJsonHttpResponse("categories",params);

  //  mJsonHttptask.executeJsonHttpResponse("wishes/4",params);


    params.put("w_id",4);
        mJsonHttptask.executeJsonHttpResponse("wish",params);



    }



    @Override
    public void onTaskCompleted(ArrayList<?> results) {
        String res="Res: ";
       ArrayList<WishesDataModel> dataModels= (ArrayList<WishesDataModel>) results;

        for (WishesDataModel model: dataModels) {
            res+= model.getW_Id() +" "+model.getHeading();
        }
        Toast.makeText(this, ""+res, Toast.LENGTH_SHORT).show();

    }
}
