package com.example.rakib.asynchttp.Models;

public class WishesDataModel {
    private int w_Id;
    private String heading;

    public WishesDataModel(int w_Id, String heading) {
        this.w_Id = w_Id;
        this.heading = heading;
    }

    public int getW_Id() {
        return w_Id;
    }

    public String getHeading() {
        return heading;
    }
}
