package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BettingPoker extends Betting{

    private int ante;

    public BettingPoker(List<Integer> playerBanks) {
        super(playerBanks);
    }

    public int getAnte()
    {
        return ante;
    }

    public void setAnte(int ante)
    {
        this.ante = ante;
    }

    public void allIn(int playerName)
    {
        placeBet(playerName, playerBanks.get(playerName) - currentBet.get(playerName));
    }


}
