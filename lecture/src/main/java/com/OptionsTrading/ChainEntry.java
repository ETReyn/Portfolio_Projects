package com.OptionsTrading;

import java.math.BigDecimal;

public class ChainEntry {

    private BigDecimal last;
    private BigDecimal strikePrice;
    private double change;
    private double bid;
    private double ask;
    private int volume;
    private int openInterest;
    private double delta;
    private double gamma;
    private double rho;
    private double theta;
    private double vega;

    public ChainEntry(BigDecimal last, BigDecimal strikePrice, double change, double bid, double ask, int volume, int openInterest, double delta, double gamma, double rho, double theta, double vega) {
        this.last = last;
        this.strikePrice = strikePrice;
        this.change = change;
        this.bid = bid;
        this.ask = ask;
        this.volume = volume;
        this.openInterest = openInterest;
        this.delta = delta;
        this.gamma = gamma;
        this.rho = rho;
        this.theta = theta;
        this.vega = vega;
    }

    public BigDecimal getStrikePrice() {
        return strikePrice;
    }

    public BigDecimal getLast() {
        return last;
    }

    public double getChange() {
        return change;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public int getVolume() {
        return volume;
    }

    public int getOpenInterest() {
        return openInterest;
    }

    @Override
    public String toString() {
        return "ChainEntry{" +
                ", Strike Price=" + strikePrice +
                "Last Price=" + last +
                ", Change=" + change +
                ", Bid=" + bid +
                ", Ask=" + ask +
                ", Volume=" + volume +
                ", Open Interest=" + openInterest +
                ", Greeks: "+
                " Delta=" + delta +
                ", Gamma=" + gamma +
                ", Rho=" + rho +
                ", Theta=" + theta +
                ", Vega=" + vega +
                '}';
    }
}
