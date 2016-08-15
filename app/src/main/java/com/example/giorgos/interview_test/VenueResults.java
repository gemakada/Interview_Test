package com.example.giorgos.interview_test;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Giorgos on 14/8/2016.
 */
public class VenueResults {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("response")
    private ReSponse response;


    public ReSponse getRes() {return response;}




}
