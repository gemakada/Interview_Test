package com.example.giorgos.interview_test;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Giorgos on 14/8/2016.
 */
public class Links {
    @SerializedName("prefix")
    private String prefix;

    @SerializedName("suffix")
    private String suffix;

    @SerializedName("width")
    private String width;

    @SerializedName("height")
    private String height;


    public String getPrefix() {return prefix;}

    public String getSuffix() {return suffix;}
    public String getWidth() {return width;}
    public String getHeight() {return height;}




}
