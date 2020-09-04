
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
    "clientId",
    "scope",
    "requestParameters",
    "resourceIds",
    "authorities",
    "approved",
    "refresh",
    "redirectUri",
    "responseTypes",
    "extensions",
    "refreshTokenRequest",
    "grantType"
})
public class Oauth2Request {

    @JsonProperty("clientId")
    private String clientId;
    @JsonProperty("scope")
    private List<Object> scope = null;
    @JsonProperty("requestParameters")
    private RequestParameters requestParameters;
    @JsonProperty("resourceIds")
    private List<Object> resourceIds = null;
    @JsonProperty("authorities")
    private List<Object> authorities = null;
    @JsonProperty("approved")
    private Boolean approved;
    @JsonProperty("refresh")
    private Boolean refresh;
    @JsonProperty("redirectUri")
    private Object redirectUri;
    @JsonProperty("responseTypes")
    private List<Object> responseTypes = null;
    @JsonProperty("extensions")
    private Extensions extensions;
    @JsonProperty("refreshTokenRequest")
    private Object refreshTokenRequest;
    @JsonProperty("grantType")
    private Object grantType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("clientId")
    public String getClientId() {
        return clientId;
    }

    @JsonProperty("clientId")
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @JsonProperty("scope")
    public List<Object> getScope() {
        return scope;
    }

    @JsonProperty("scope")
    public void setScope(List<Object> scope) {
        this.scope = scope;
    }

    @JsonProperty("requestParameters")
    public RequestParameters getRequestParameters() {
        return requestParameters;
    }

    @JsonProperty("requestParameters")
    public void setRequestParameters(RequestParameters requestParameters) {
        this.requestParameters = requestParameters;
    }

    @JsonProperty("resourceIds")
    public List<Object> getResourceIds() {
        return resourceIds;
    }

    @JsonProperty("resourceIds")
    public void setResourceIds(List<Object> resourceIds) {
        this.resourceIds = resourceIds;
    }

    @JsonProperty("authorities")
    public List<Object> getAuthorities() {
        return authorities;
    }

    @JsonProperty("authorities")
    public void setAuthorities(List<Object> authorities) {
        this.authorities = authorities;
    }

    @JsonProperty("approved")
    public Boolean getApproved() {
        return approved;
    }

    @JsonProperty("approved")
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @JsonProperty("refresh")
    public Boolean getRefresh() {
        return refresh;
    }

    @JsonProperty("refresh")
    public void setRefresh(Boolean refresh) {
        this.refresh = refresh;
    }

    @JsonProperty("redirectUri")
    public Object getRedirectUri() {
        return redirectUri;
    }

    @JsonProperty("redirectUri")
    public void setRedirectUri(Object redirectUri) {
        this.redirectUri = redirectUri;
    }

    @JsonProperty("responseTypes")
    public List<Object> getResponseTypes() {
        return responseTypes;
    }

    @JsonProperty("responseTypes")
    public void setResponseTypes(List<Object> responseTypes) {
        this.responseTypes = responseTypes;
    }

    @JsonProperty("extensions")
    public Extensions getExtensions() {
        return extensions;
    }

    @JsonProperty("extensions")
    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    @JsonProperty("refreshTokenRequest")
    public Object getRefreshTokenRequest() {
        return refreshTokenRequest;
    }

    @JsonProperty("refreshTokenRequest")
    public void setRefreshTokenRequest(Object refreshTokenRequest) {
        this.refreshTokenRequest = refreshTokenRequest;
    }

    @JsonProperty("grantType")
    public Object getGrantType() {
        return grantType;
    }

    @JsonProperty("grantType")
    public void setGrantType(Object grantType) {
        this.grantType = grantType;
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
