package com.example.rakib.asynchttp.AsyncTaskHost;

import com.example.rakib.asynchttp.Models.Categories_DataModel;
import com.example.rakib.asynchttp.Models.WishesDataModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/* This class will Convert jsonData into ArrayList according to Model */
public class JsonDataFactory  {




    public static ArrayList<?> fromJson_To_Category_model(JSONObject jsonObject){

        ArrayList<Categories_DataModel> modelArrayList=new ArrayList<>();
        try {
            int length=jsonObject.getJSONArray("category").length();

            for (int i=0;i<length;i++){
                modelArrayList.add(new Categories_DataModel(
                        jsonObject.getJSONArray("category").getJSONObject(i).getInt("c_id"),
                        jsonObject.getJSONArray("category").getJSONObject(i).getString("c_name"),
                        jsonObject.getJSONArray("category").getJSONObject(i).getInt("no_item")

                ));
            }

            return modelArrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static ArrayList<?> fromJson_To_Wishes_Model(JSONObject jsonObject){

        ArrayList<WishesDataModel> modelArrayList=new ArrayList<>();
        try {
            int length=jsonObject.getJSONArray("wishes").length();

            for (int i=0;i<length;i++){
                modelArrayList.add(new WishesDataModel(
                        jsonObject.getJSONArray("wishes").getJSONObject(i).getInt("w_id"),
                        jsonObject.getJSONArray("wishes").getJSONObject(i).getString("heading")

                ));
            }

            return modelArrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
