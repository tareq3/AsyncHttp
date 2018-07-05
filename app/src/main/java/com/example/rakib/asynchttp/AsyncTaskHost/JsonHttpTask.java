package com.example.rakib.asynchttp.AsyncTaskHost;

import android.util.Log;

import com.example.rakib.asynchttp.Models.Categories_DataModel;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class JsonHttpTask {

    //Declaration for AsyncHttpClient
    private AsyncHttpClient asyncHttpClient;

    /*
    Request params are the parameter that we pass in to our api
    */
    //Request params declarration
    private RequestParams requestParams;


    //The base Url or the host along some sort of path
    String BASE_URL="http://wishermanager.000webhostapp.com/api/v1/";

    //An Instance of my Interface
    JsonHttpTaskCompleteListener jsonHttpTaskCompleteListener;



    //Constructor of this class
    public JsonHttpTask( JsonHttpTaskCompleteListener jsonHttpTaskCompleteListener) {

        //as this two instance creates in here and dies in here as well.
        this.asyncHttpClient =new AsyncHttpClient();
        this.requestParams = new RequestParams();

        //as this is what pass the result..
        this.jsonHttpTaskCompleteListener=jsonHttpTaskCompleteListener;

    }

 /*   Total Api URL= BaseUrl + surUrl

    // Base URl: The part of url which is fixed
    //surUrl: the part of url which is dynamic

    //params: for passing the parameters for the call
 */

    // this method execute Http call
    public void executeJsonHttpResponse(String surUrl,HashMap<String, Object> params){

        for (Map.Entry param: params.entrySet()) {
            requestParams.put((String) param.getKey(), param.getValue());
        }

       // Total Api URL= BaseUrl + surUrl
       String cmd_URL= BASE_URL+surUrl;

        //as my request is get
        asyncHttpClient.get(cmd_URL,requestParams,new JsonHttpResponseHandler(){



            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);


                //we are pushing the value into the interface to convey.
                jsonHttpTaskCompleteListener.onTaskCompleted(


          // JsonDataFactory.fromJson_To_Category_model(response) //for getting json data into formatedArrayList

            //     JsonDataFactory.fromJson_To_Wishes_Model(response)

                        JsonDataFactory.fromJson_To_Wishes_Model_Single(response)

                );
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
