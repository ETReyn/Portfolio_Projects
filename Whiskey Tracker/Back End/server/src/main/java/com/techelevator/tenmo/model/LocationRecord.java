package com.techelevator.tenmo.model;

public class LocationRecord {

    String address;
    String county;

    public LocationRecord(String address, String county) {
        this.address = address;
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
