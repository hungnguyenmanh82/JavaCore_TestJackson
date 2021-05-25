
package com.json.model.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * vào đây để gen từ Json ra Java Class
 *    http://www.jsonschema2pojo.org/
 * 
 * Lưu ý: @annotation của Gson và Jackson là khác nhau   
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
