package com.example.giorgos.interview_test;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Giorgos on 12/8/2016.
 */
public class VenuesResponse {
        @SerializedName("meta")
        private Meta meta;
        @SerializedName("response")
        private ReSponse response;


        public ReSponse getRes () {
            return response;
        }

    public Meta getMEta () {
        return meta;
    }

        public void setRes(ReSponse x) {
            this.response=x;
        }

    }

