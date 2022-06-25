package com.martingale;

import java.util.LinkedHashMap;

public class RouletteSimulation {

    final static int TOTAL_ATTEMPTS = 10000;
    final static int STARTING_CASH = 50000;

    public static void main(String[] args) {

        final int tableMax = 500;
        final int initialBet = 50;
        final int numWinsNeeded = 1;
        int totalLosses = 0;
        int numRounds = TOTAL_ATTEMPTS;
        int maxWinsNeeded = 10;

        for (int i = tableMax; i < 50000; i += 500) {
            for (int j = initialBet; j < 10000; j *= 2) {
                for (int k = numWinsNeeded; k < maxWinsNeeded; k++) {
                    getCurrentSimulation(tableMax, j, k, STARTING_CASH, totalLosses, numRounds);
                    totalLosses = 0;
                    numRounds = TOTAL_ATTEMPTS;
                }
            }
            System.out.println("===================================================");
        }
    }

    public static void getCurrentSimulation(int tableMax, int initialBet, int numWinsNeeded, int totalCashOnHand, int totalLosses, int numRounds) {
        MartingaleRules mS = new MartingaleRules(tableMax, initialBet, numWinsNeeded);
        for (int i = 0; i < TOTAL_ATTEMPTS; i++) {
            mS.setNewBet();
            if (mS.bettingRound()) {
                totalCashOnHand += (initialBet * numWinsNeeded);
            } else {
                totalCashOnHand -= mS.bankNeeded();
                totalLosses++;
            }
            if (totalCashOnHand <= initialBet) {
                numRounds = i + 1;
                break;
            }
            mS.setNumWins(0);
        }
        if (numRounds == TOTAL_ATTEMPTS && mS.bankNeeded() > 0) {
            System.out.println("Table Parameters: ");
            System.out.println("Table max: " + tableMax + " ---- Initial bet: " + initialBet + " ----- Total number of wins needed: " + numWinsNeeded + " ----- Total number of attempts: " + TOTAL_ATTEMPTS);
            System.out.println("Number of rounds played: " + numRounds);
            System.out.println("Total number of losses: " + mS.getTotalNumberOfLosses() + " " + totalLosses);
            System.out.println("Total Cash: " + totalCashOnHand);
            System.out.println("Bank needed: " + mS.bankNeeded());
        }

    }
}
