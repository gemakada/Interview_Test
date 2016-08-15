package com.example.giorgos.interview_test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Giorgos on 14/8/2016.
 */
public class data {
    @SerializedName("categories")
    private List<CategoryList> Categories;

    @SerializedName("photos")
    private pics pictures;

    @SerializedName("rating")
    private String rating;

    @SerializedName("tips")
    private Tips tips;




    public List<CategoryList> getCategories() {return Categories;}

    public String getRating() {
        return rating;
    }

    public pics getPictures() {return pictures;}

    public Tips getTips() {return tips;}


}
