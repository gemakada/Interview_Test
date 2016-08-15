package com.example.giorgos.interview_test;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Giorgos on 12/8/2016.
 */
public class Local {
    @SerializedName("address")
   private String address;
@SerializedName("lat")
private String lat;
@SerializedName("lng")
private String lon;

    public void setLat( String lat) {
        this.lat=lat;
    }

    public String getLat() {
        return lat;
    }


    public void setLon( String lon) {
        this.lon=lon;
    }

    public String getLon() {
        return lon;
    }

    public void setAddress( String adr) {
        this.address=adr;
    }

    public String getAddress() {
        return address;
    }


}
