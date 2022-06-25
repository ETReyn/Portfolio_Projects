package com.martingale;

import org.junit.Assert;
import org.junit.Test;

public class MartingaleRulesTest {

    private MartingaleRules sut;

    @Test
    public void test_bank_needed()
    {
        int tableMax = 500; int initialBet = 100; int numWinsNeeded = 5;
        sut = new MartingaleRules(tableMax, initialBet, numWinsNeeded);
        int output = sut.bankNeeded();
        Assert.assertEquals(700, output);
        int tableMax1 = 500; int initialBet1 = 500; int numWinsNeeded1 = 5;
        sut = new MartingaleRules(tableMax1, initialBet1, numWinsNeeded1);
        output = sut.bankNeeded();
        Assert.assertEquals(500, output);
        int tableMax2 = 500; int initialBet2 = 10; int numWinsNeeded2 = 5;
        sut = new MartingaleRules(tableMax2, initialBet2, numWinsNeeded2);
        output = sut.bankNeeded();
        Assert.assertEquals(630, output);
        int tableMax3 = 500; int initialBet3 = 250; int numWinsNeeded3 = 5;
        sut = new MartingaleRules(tableMax3, initialBet3, numWinsNeeded3);
        output = sut.bankNeeded();
        Assert.assertEquals(750, output);
        int tableMax4 = 10; int initialBet4 = 100; int numWinsNeeded4 = 5;
        sut = new MartingaleRules(tableMax4, initialBet4, numWinsNeeded4);
        output = sut.bankNeeded();
        Assert.assertEquals(0, output);
    }

    @Test
    public void test_possible_losses()
    {
        int tableMax = 500; int initialBet = 100; int numWinsNeeded = 5;
        sut = new MartingaleRules(tableMax, initialBet, numWinsNeeded);
        int output = sut.numPossibleLosses();
        Assert.assertEquals(3, output);
        int tableMax1 = 500; int initialBet1 = 500; int numWinsNeeded1 = 5;
        sut = new MartingaleRules(tableMax1, initialBet1, numWinsNeeded1);
        output = sut.numPossibleLosses();
        Assert.assertEquals(1, output);
        int tableMax2 = 500; int initialBet2 = 10; int numWinsNeeded2 = 5;
        sut = new MartingaleRules(tableMax2, initialBet2, numWinsNeeded2);
        output = sut.numPossibleLosses();
        Assert.assertEquals(6, output);
        int tableMax3 = 500; int initialBet3 = 250; int numWinsNeeded3 = 5;
        sut = new MartingaleRules(tableMax3, initialBet3, numWinsNeeded3);
        output = sut.numPossibleLosses();
        Assert.assertEquals(2, output);
        int tableMax4 = 10; int initialBet4 = 100; int numWinsNeeded4 = 5;
        sut = new MartingaleRules(tableMax4, initialBet4, numWinsNeeded4);
        output = sut.numPossibleLosses();
        Assert.assertEquals(0, output);

    }

    @Test
    public void get_max_bet()
    {
        int tableMax = 500; int initialBet = 100; int numWinsNeeded = 5;
        sut = new MartingaleRules(tableMax, initialBet, numWinsNeeded);
        int output = sut.getMaxBet();
        Assert.assertEquals(400, output);
        int tableMax1 = 500; int initialBet1 = 500; int numWinsNeeded1 = 5;
        sut = new MartingaleRules(tableMax1, initialBet1, numWinsNeeded1);
        output = sut.getMaxBet();
        Assert.assertEquals(500, output);
        int tableMax2 = 500; int initialBet2 = 10; int numWinsNeeded2 = 5;
        sut = new MartingaleRules(tableMax2, initialBet2, numWinsNeeded2);
        output = sut.getMaxBet();
        Assert.assertEquals(320, output);
        int tableMax3 = 500; int initialBet3 = 250; int numWinsNeeded3 = 5;
        sut = new MartingaleRules(tableMax3, initialBet3, numWinsNeeded3);
        output = sut.getMaxBet();
        Assert.assertEquals(500, output);
        int tableMax4 = 10; int initialBet4 = 100; int numWinsNeeded4 = 5;
        sut = new MartingaleRules(tableMax4, initialBet4, numWinsNeeded4);
        output = sut.getMaxBet();
        Assert.assertEquals(0, output);
    }

    @Test
    public void test_betting_round()
    {
        int tableMax = 500; int initialBet = 100; int numWinsNeeded = 5;
        sut = new MartingaleRules(tableMax, initialBet, numWinsNeeded);
        sut.setNewBet(sut.getMaxBet()*2);
        sut.setNumWins(numWinsNeeded - 1);
        boolean output = sut.bettingRound();
        Assert.assertFalse(output);
        int tableMax1 = 500; int initialBet1 = 500; int numWinsNeeded1 = 5;
        sut = new MartingaleRules(tableMax1, initialBet1, numWinsNeeded1);
        sut.setNewBet(sut.getMaxBet());
        sut.setNumWins(numWinsNeeded);
        output = sut.bettingRound();
        Assert.assertTrue(output);
        int tableMax2 = 500; int initialBet2 = 10; int numWinsNeeded2 = 5;
        sut = new MartingaleRules(tableMax2, initialBet2, numWinsNeeded2);
        sut.setNewBet(sut.getMaxBet()/4);
        sut.setNumWins(numWinsNeeded );
        output = sut.bettingRound();
        Assert.assertTrue(output);
        int tableMax3 = 500; int initialBet3 = 250; int numWinsNeeded3 = 5;
        sut = new MartingaleRules(tableMax3, initialBet3, numWinsNeeded3);
        sut.setNewBet(initialBet3);
        sut.setNumWins(numWinsNeeded);
        output = sut.bettingRound();
        Assert.assertTrue(output);
        int tableMax4 = 10; int initialBet4 = 100; int numWinsNeeded4 = 5;
        sut = new MartingaleRules(tableMax4, initialBet4, numWinsNeeded4);
        output = sut.bettingRound();
        Assert.assertFalse(output);

    }
}
