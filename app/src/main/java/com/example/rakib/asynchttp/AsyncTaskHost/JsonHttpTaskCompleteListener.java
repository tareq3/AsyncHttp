package com.example.rakib.asynchttp.AsyncTaskHost;

import com.example.rakib.asynchttp.Models.Categories_DataModel;

import java.util.ArrayList;

public interface JsonHttpTaskCompleteListener {
     void onTaskCompleted(ArrayList<?> results);
}
