package com.OptionsTrading;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OptionsChain {

    //callOrPut - 0 for call 1 for put
    private String companyName;
    private String companyAbbreviation;
    private List<ChainEntry>  chain;
    private boolean callOrPut;

    public OptionsChain(String companyName, String companyAbbreviation) {
        this.companyName = companyName;
        this.companyAbbreviation = companyAbbreviation;
        chain = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAbbreviation() {
        return companyAbbreviation;
    }

    public List<ChainEntry> getChain() {
        return chain;
    }

    public boolean isCallOrPut() {
        return callOrPut;
    }

    public void addToChain(ChainEntry entry)
    {
        chain.add(entry);
    }

    public void setChain(List<ChainEntry> chain) {
        this.chain = chain;
    }

    public void setCallOrPut(boolean callOrPut) {
        this.callOrPut = callOrPut;
    }
}
