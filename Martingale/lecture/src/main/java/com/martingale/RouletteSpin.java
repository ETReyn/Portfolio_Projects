package com.martingale;

import java.util.Random;

public class RouletteSpin {

    int numWins;
    int spinSimulation;
    public RouletteSpin()
    {
        spinSimulation = 0;
        numWins = 0;
    }

    public int getSpinSimulation() {
        return spinSimulation;
    }

    public int getNumWins() {
        return numWins;
    }

    public void setNumWins(int numWins) {
        this.numWins = numWins;
    }

    public boolean spin()
    {
        Random rand = new Random();
        spinSimulation = rand.nextInt( 38);
        if(spinSimulation < 17)
        {
            numWins++;
            return true;
        }
        return false;
    }
}
