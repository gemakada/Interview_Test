package com.example.giorgos.interview_test;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Giorgos on 12/8/2016.
 */
public class ReSponse {
    @SerializedName("venues")
    private List <Venue> Venues;

    @SerializedName("venue")
    private data info;


    public void setVenues(List<Venue> x ) {
        this.Venues=x;
    }

    public List<Venue> getVenues() {
        return Venues;
    }

    public void setInfo(data info) {this.info=info;}

    public data getInfo() {return info;}


}
