package com.database.stuff.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;


public class Info {
    @JsonProperty("license_text")
    private String licenseText;
    @JsonProperty("license_links")
    private String[] licenseLinks;
    private String version;

    public String getLicenseText() {
        return licenseText;
    }

    public void setLicenseText(String licenseText) {
        this.licenseText = licenseText;
    }

    public String[] getLicenseLinks() {
        return licenseLinks;
    }

    public void setLicenseLinks(String[] licenseLinks) {
        this.licenseLinks = licenseLinks;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Info{" +
                "licenseText='" + licenseText + '\'' +
                ", licenseLinks=" + Arrays.toString(licenseLinks) +
                ", version='" + version + '\'' +
                '}';
    }
}
