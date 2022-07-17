package com.techelevator.model;

public class OptionsChainData {


    private String symbol;
    private String success;
    private String underlying;
    private String strategy;
    private String interval;
    private String isDelayed;
    private String idIndex;
    private String interestRate;
    private String underlyingPrice;
    private String volatility;
    private String daysToExpiration;
    private Expiration putExpDateMap;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getUnderlying() {
        return underlying;
    }

    public void setUnderlying(String underlying) {
        this.underlying = underlying;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getIsDelayed() {
        return isDelayed;
    }

    public void setIsDelayed(String isDelayed) {
        this.isDelayed = isDelayed;
    }

    public String getIdIndex() {
        return idIndex;
    }

    public void setIdIndex(String idIndex) {
        this.idIndex = idIndex;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getUnderlyingPrice() {
        return underlyingPrice;
    }

    public void setUnderlyingPrice(String underlyingPrice) {
        this.underlyingPrice = underlyingPrice;
    }

    public String getVolatility() {
        return volatility;
    }

    public void setVolatility(String volatility) {
        this.volatility = volatility;
    }

    public String getDaysToExpiration() {
        return daysToExpiration;
    }

    public void setDaysToExpiration(String daysToExpiration) {
        this.daysToExpiration = daysToExpiration;
    }

    public Expiration getPutExpDateMap() {
        return putExpDateMap;
    }

    public void setPutExpDateMap(Expiration putExpDateMap) {
        this.putExpDateMap = putExpDateMap;
    }
}
