package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Betting {

    protected List<Integer> playerBanks = new ArrayList<>();
    protected List<Integer> currentBet = new ArrayList<>();
    private int allBetsThisRound;

    public Betting(List<Integer> playerBanks) {
        this.playerBanks = playerBanks;
    }

    public List<Integer> getPlayerBanks() {
        return playerBanks;
    }

    public List<Integer> getCurrentBet() {
        return currentBet;
    }

    public int getPlayerBanks(int playerNumber) {
        return playerBanks.get(playerNumber);
    }

    public int getCurrentBet(int playerNumber) {
        return currentBet.get(playerNumber);
    }

    public int getAllBetsThisRound() {
        allBetsThisRound = 0;
        for(Integer bet : currentBet)
        {
            allBetsThisRound +=bet;
        }
        return allBetsThisRound;
    }

    public boolean placeBet(int playerNumber, int betSize)
    {
        if(playerBanks.get(playerNumber) < betSize)
        {
            System.out.println("You are attempting to bet more than you currently have, try again!");
             return false;
        }
        if(playerNumber >= currentBet.size())
        {
            currentBet.add(betSize);
        }
        else
        {
            currentBet.set(playerNumber, currentBet.get(playerNumber) + betSize);
        }
        return true;
    }

    public void addToBank(int playerNumber, int moneyToAddToBank)
    {
        playerBanks.set(playerNumber, moneyToAddToBank + playerBanks.get(playerNumber));
    }

    public void setBetToZero()
    {
        allBetsThisRound = 0;
        for(int i = 0; i < currentBet.size(); i++)
        {
            currentBet.set(i, 0);
        }
    }
}
