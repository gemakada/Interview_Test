package com.example.giorgos.interview_test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Giorgos on 14/8/2016.
 */
public class photolist {
    @SerializedName("type")
    private String type;

    @SerializedName("items")
    private List<Links> links;

    public List<Links> getLinks() {return links;}


}
