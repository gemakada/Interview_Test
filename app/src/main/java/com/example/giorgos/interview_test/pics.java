package com.example.giorgos.interview_test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Giorgos on 14/8/2016.
 */
public class pics {
    @SerializedName("count")
    private String count;

    @SerializedName("groups")
    private List<photolist> photografies;


    public List<photolist> getPhotografies() {return photografies;}
    public String getCount() {return count;}


}
