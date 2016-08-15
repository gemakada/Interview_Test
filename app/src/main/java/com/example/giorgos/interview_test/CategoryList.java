package com.example.giorgos.interview_test;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Giorgos on 14/8/2016.
 */
public class CategoryList {
    @SerializedName("name")
    private String name;


    public void setName(String name) {this.name=name;}

    public String getName() {return name;}



}
