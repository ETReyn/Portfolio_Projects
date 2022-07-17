package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Expiration {

    @JsonProperty("2022-07-01:1")
    private List<Price> strikePrices;

    public List<Price> getStrikePrices() {
        return strikePrices;
    }

    public void setStrikePrices(List<Price> strikePrices) {
        this.strikePrices = strikePrices;
    }
}
