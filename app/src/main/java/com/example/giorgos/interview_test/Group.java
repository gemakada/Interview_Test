package com.example.giorgos.interview_test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Giorgos on 15/8/2016.
 */
public class Group {
    @SerializedName("type")
    private String type;

    @SerializedName("count")
    private String count;

    @SerializedName("items")
    private List<Items> items;


    public List<Items> getItems() {return items;}

    public String getType() { return type;}

    public String getCount() {return count;}


}
