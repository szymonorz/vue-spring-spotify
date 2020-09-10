
package com.example.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorities",
    "details",
    "authenticated",
    "userAuthentication",
    "oauth2Request",
    "principal",
    "clientOnly",
    "credentials",
    "name"
})
public class UserToken {

    @JsonProperty("authorities")
    private List<Authority> authorities = null;
    @JsonProperty("details")
    private Details details;
    @JsonProperty("authenticated")
    private Boolean authenticated;
    @JsonProperty("userAuthentication")
    private UserAuthentication userAuthentication;
    @JsonProperty("oauth2Request")
    private Oauth2Request oauth2Request;
    @JsonProperty("principal")
    private String principal;
    @JsonProperty("clientOnly")
    private Boolean clientOnly;
    @JsonProperty("credentials")
    private String credentials;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("authorities")
    public List<Authority> getAuthorities() {
        return authorities;
    }

    @JsonProperty("authorities")
    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @JsonProperty("details")
    public Details getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(Details details) {
        this.details = details;
    }

    @JsonProperty("authenticated")
    public Boolean getAuthenticated() {
        return authenticated;
    }

    @JsonProperty("authenticated")
    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    @JsonProperty("userAuthentication")
    public UserAuthentication getUserAuthentication() {
        return userAuthentication;
    }

    @JsonProperty("userAuthentication")
    public void setUserAuthentication(UserAuthentication userAuthentication) {
        this.userAuthentication = userAuthentication;
    }

    @JsonProperty("oauth2Request")
    public Oauth2Request getOauth2Request() {
        return oauth2Request;
    }

    @JsonProperty("oauth2Request")
    public void setOauth2Request(Oauth2Request oauth2Request) {
        this.oauth2Request = oauth2Request;
    }

    @JsonProperty("principal")
    public String getPrincipal() {
        return principal;
    }

    @JsonProperty("principal")
    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    @JsonProperty("clientOnly")
    public Boolean getClientOnly() {
        return clientOnly;
    }

    @JsonProperty("clientOnly")
    public void setClientOnly(Boolean clientOnly) {
        this.clientOnly = clientOnly;
    }

    @JsonProperty("credentials")
    public String getCredentials() {
        return credentials;
    }

    @JsonProperty("credentials")
    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
