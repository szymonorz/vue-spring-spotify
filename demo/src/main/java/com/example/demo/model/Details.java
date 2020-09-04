
package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "remoteAddress",
    "sessionId",
    "tokenValue",
    "tokenType",
    "decodedDetails"
})
public class Details {

    @JsonProperty("remoteAddress")
    private String remoteAddress;
    @JsonProperty("sessionId")
    private String sessionId;
    @JsonProperty("tokenValue")
    private String tokenValue;
    @JsonProperty("tokenType")
    private String tokenType;
    @JsonProperty("decodedDetails")
    private Object decodedDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("remoteAddress")
    public String getRemoteAddress() {
        return remoteAddress;
    }

    @JsonProperty("remoteAddress")
    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }

    @JsonProperty("sessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("tokenValue")
    public String getTokenValue() {
        return tokenValue;
    }

    @JsonProperty("tokenValue")
    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    @JsonProperty("tokenType")
    public String getTokenType() {
        return tokenType;
    }

    @JsonProperty("tokenType")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @JsonProperty("decodedDetails")
    public Object getDecodedDetails() {
        return decodedDetails;
    }

    @JsonProperty("decodedDetails")
    public void setDecodedDetails(Object decodedDetails) {
        this.decodedDetails = decodedDetails;
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
