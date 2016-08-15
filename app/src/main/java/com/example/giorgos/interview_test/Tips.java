package com.example.giorgos.interview_test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Giorgos on 15/8/2016.
 */
public class Tips {
    @SerializedName("count")
    private String count;

    @SerializedName("groups")
    private List<Group> groups;

    public String getCount() { return count;}

    public List<Group> getGroups() {return groups;}



}
