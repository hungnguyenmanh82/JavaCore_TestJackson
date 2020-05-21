
package com.example.model.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
http://www.jsonschema2pojo.org/
*/
public class GoogleOauth3 {

    @SerializedName("web")
    @Expose
    private Web web;

    public Web getWeb() {
        return web;
    }

    public void setWeb(Web web) {
        this.web = web;
    }

}
