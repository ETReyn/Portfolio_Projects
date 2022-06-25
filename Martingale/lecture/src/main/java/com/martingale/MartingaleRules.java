package com.martingale;

public class MartingaleRules {

    private int tableMax;
    private int initialBet;
    private int numWinsNeeded;
    private int newBet;
    private int totalNumberOfLosses;
    private int numWins;
//    private final int MAX_LOSSES = 3;

    public MartingaleRules(int tableMax, int initialBet, int numWinsNeeded)
    {
        this.tableMax = tableMax;
        this.initialBet = initialBet;
        this.numWinsNeeded = numWinsNeeded;
        newBet = initialBet;
        numWins = 0;
        totalNumberOfLosses = 0;
    }

    public int getTableMax() {
        return tableMax;
    }

    public int getNewBet()
    {
        return newBet;
    }

    public void setNewBet(int newBet) {
        this.newBet = newBet;
    }

    public void setNumWins(int numWins) {
        this.numWins = numWins;
    }

    public int getInitialBet() {
        return initialBet;
    }

    public int getTotalNumberOfLosses() { return totalNumberOfLosses; }

    public void setTableMax(int tableMax) {
        this.tableMax = tableMax;
    }

    public int getNumWinsNeeded() {
        return numWinsNeeded;
    }

    public void setNewBet() {
        newBet = initialBet;
    }

    public int getMaxBet()
    {
        int maxBet = 0;
        if(initialBet <= tableMax) {
            maxBet = initialBet;
            while (maxBet <= tableMax) {
                maxBet *= 2;
            }
        }
        return maxBet/2;
    }


    public int numPossibleLosses()
    {
        int numLosses = 0;
        int currentBet = initialBet;
        while(getMaxBet() >= currentBet)
        {
            currentBet *= 2;
            numLosses++;
        }
        return numLosses;
    }


    public int bankNeeded()
    {
        int bank = 0; int currentBet = initialBet;
        if(getInitialBet() <= getTableMax()) {
            bank = initialBet;
            while (currentBet < getMaxBet()) {
                currentBet *= 2;
                bank += currentBet;
            }
        }
        return bank;
    }

    public boolean bettingRound()
    {
        RouletteSpin rS = new RouletteSpin();
        while(newBet <= getMaxBet() && numWins < numWinsNeeded)
        {
            boolean chance = rS.spin();
            if(chance)
            {
                numWins++;
                newBet = initialBet;
            }
            else {
                newBet *= 2;
            }
        }
        if(newBet > getMaxBet())
        {
            totalNumberOfLosses++;
            return false;
        }
        return true;
    }
}
