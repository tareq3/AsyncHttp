package com.example.rakib.asynchttp.Models;

public class Categories_DataModel {

    private    int C_ID;
    private    String Title;
    private   int getNumberofItem;

    public Categories_DataModel(int c_ID, String title, int getNumberofItem) {
        C_ID = c_ID;
        Title = title;
        this.getNumberofItem = getNumberofItem;
    }

    public Categories_DataModel() {

    }

    public int getC_ID() {
        return C_ID;
    }

    public String getTitle() {
        return Title;
    }

    public int getGetNumberofItem() {
        return getNumberofItem;
    }
}
