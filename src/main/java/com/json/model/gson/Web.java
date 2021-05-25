
package com.json.model.gson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * vào đây để gen từ Json ra Java Class
 *    http://www.jsonschema2pojo.org/
 * 
 * Lưu ý: @annotation của Gson và Jackson là khác nhau   
 */
public class Web {

    @SerializedName("client_id")
    @Expose
    private String clientId;
    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("auth_uri")
    @Expose
    private String authUri;
    @SerializedName("token_uri")
    @Expose
    private String tokenUri;
    @SerializedName("auth_provider_x509_cert_url")
    @Expose
    private String authProviderX509CertUrl;
    @SerializedName("client_secret")
    @Expose
    private String clientSecret;
    @SerializedName("redirect_uris")
    @Expose
    private List<String> redirectUris = null;
    @SerializedName("javascript_origins")
    @Expose
    private List<String> javascriptOrigins = null;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getAuthUri() {
        return authUri;
    }

    public void setAuthUri(String authUri) {
        this.authUri = authUri;
    }

    public String getTokenUri() {
        return tokenUri;
    }

    public void setTokenUri(String tokenUri) {
        this.tokenUri = tokenUri;
    }

    public String getAuthProviderX509CertUrl() {
        return authProviderX509CertUrl;
    }

    public void setAuthProviderX509CertUrl(String authProviderX509CertUrl) {
        this.authProviderX509CertUrl = authProviderX509CertUrl;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public List<String> getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(List<String> redirectUris) {
        this.redirectUris = redirectUris;
    }

    public List<String> getJavascriptOrigins() {
        return javascriptOrigins;
    }

    public void setJavascriptOrigins(List<String> javascriptOrigins) {
        this.javascriptOrigins = javascriptOrigins;
    }

}
