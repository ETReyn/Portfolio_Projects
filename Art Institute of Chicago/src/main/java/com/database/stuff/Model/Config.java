package com.database.stuff.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Config {

    @JsonProperty("iiif_url")
    private String iiifUrl;
    @JsonProperty("website_url")
    private String websiteUrl;

    public String getIiifUrl() {
        return iiifUrl;
    }

    public void setIiifUrl(String iiifUrl) {
        this.iiifUrl = iiifUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    @Override
    public String toString() {
        return "Config{" +
                "iiifUrl='" + iiifUrl + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                '}';
    }
}
