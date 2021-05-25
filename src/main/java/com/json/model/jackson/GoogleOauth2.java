
package com.json.model.jackson;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * vào đây để gen từ Json ra Java Class
 *    http://www.jsonschema2pojo.org/
 * 
 * Lưu ý: @annotation của Gson và Jackson là khác nhau   
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "web"
})
public class GoogleOauth2 {

    @JsonProperty("web")
    private Web web;

    @JsonProperty("web")
    public Web getWeb() {
        return web;
    }

    @JsonProperty("web")
    public void setWeb(Web web) {
        this.web = web;
    }



}
