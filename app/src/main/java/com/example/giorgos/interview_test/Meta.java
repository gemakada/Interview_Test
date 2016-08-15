package com.example.giorgos.interview_test;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Giorgos on 12/8/2016.
 */
public class Meta {
    @SerializedName("code")
    private String code;
    @SerializedName("requestId")
    private String ID;

    public String getCode() {
        return code;
    }


}
