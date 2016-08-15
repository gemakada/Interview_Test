package com.example.giorgos.interview_test;

/**
 * Created by Giorgos on 12/8/2016.
 */
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Venue {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("location")
    private Local location;

    private String rating;
    private String category;
    private String link;
    private String Tips;


    public void setId( String id) {
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setName( String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setLocation( Local x) {
        this.location=x;
    }

    public Local getLocation() {
        return location;
    }


    public void setRating(String rating) {this.rating=rating;}

    public void setCategory(String category){this.category=category;}

    public String getRating() {return rating;}

    public String getCategory() {return category;}

    public String getLink() {return link;}

    public void setLink(String link) {this.link=link;}

    public void setTips(String x) {this.Tips=x;}

    public String getTips() {return Tips;}


}
