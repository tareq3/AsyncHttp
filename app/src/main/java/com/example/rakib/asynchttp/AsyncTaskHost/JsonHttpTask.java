package com.example.rakib.asynchttp.AsyncTaskHost;

import com.example.rakib.asynchttp.Models.Categories_DataModel;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class JsonHttpTask {
    private AsyncHttpClient asyncHttpClient;
    private RequestParams requestParams;


    String BASE_URL="http://wishermanager.000webhostapp.com/api/v1/";
    JsonHttpTaskCompleteListener jsonHttpTaskCompleteListener;




    public JsonHttpTask( JsonHttpTaskCompleteListener jsonHttpTaskCompleteListener) {
        this.asyncHttpClient =new AsyncHttpClient();
        this.requestParams = new RequestParams();
        this.jsonHttpTaskCompleteListener=jsonHttpTaskCompleteListener;

    }



    public void executeJsonHttpResponse(String surUrl,HashMap<String, Object> params){

        for (Map.Entry param: params.entrySet()) {
            requestParams.put((String) param.getKey(), param.getValue());
        }
       String cmd_URL=BASE_URL+surUrl;
        asyncHttpClient.get(cmd_URL,requestParams,new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                jsonHttpTaskCompleteListener.onTaskCompleted(
                       JsonDataFactory.fromJson_To_Wishes_Model(response) //for getting json data into formatedArrayList
                );
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
