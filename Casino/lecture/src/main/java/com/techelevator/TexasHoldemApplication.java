package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TexasHoldemApplication extends GameClass {
    private BettingPoker playersBankClass;
    private Scanner keyboard;

    public TexasHoldemApplication(Scanner keyboard)
    {
        this.keyboard = keyboard;
    }

    public String controlFlow() {

        Deck newDeck = new Deck(askUserForDeckSize());
        String repeat = "y";
        List<Integer> winningPlayer = new ArrayList<>();
        //Creates the shoe with the required number of decks

        PokerHand[] numPlayers = new PokerHand[askUserForDeckSize()];
        int[][] max = new int[numPlayers.length][10];
        PokerHand publicCards = new PokerHand(newDeck);
        //Creates an array of hands to simulate the number of players

        List<Integer> playerBank = new ArrayList<>();
        for (int i = 0; i < numPlayers.length; i++) {
            System.out.print("What is the value of player " + (i + 1) + "'s bank?: ");
            String bankVal = keyboard.nextLine();
            int intBankVal = Integer.parseInt(bankVal);
            playerBank.add(intBankVal);
        }
        BettingPoker playersBankClass = new BettingPoker(playerBank);
        //Creates each player's bank

        System.out.println("What would you like the ante to be for this game?");
        String stringSetAnte = keyboard.nextLine();
        playersBankClass.setAnte(Integer.parseInt(stringSetAnte));
        //Creates each player's bank

        while (repeat.equalsIgnoreCase("y")) {
            System.out.println("Shuffling deck(s) and dealing cards...");
            newDeck.shuffleWithoutJokers();
            for (int i = 0; i < numPlayers.length; i++) {
                if (playersBankClass.getPlayerBanks(i) > playersBankClass.getAnte()) {
                    numPlayers[i] = new PokerHand(newDeck);
                    numPlayers[i].dealHand(newDeck.dealTwoCards());
                }
            }
            //Shuffles deck and then deals two cards to each player
            showPlayersCards(numPlayers.length, numPlayers);
            System.out.println();
            //Shows players their hands
            System.out.println("==========================================================================");
            for (int i = 0; i < numPlayers.length; i++) {
                if (playersBankClass.getPlayerBanks(i) <= playersBankClass.getAnte()) {
                    continue;
                }
                int firstBettingRound = anteUp(i, playersBankClass.getAnte(), numPlayers[i]);
                boolean allowableBet = playersBankClass.placeBet(i, firstBettingRound);
            }
            //Ante up round
            System.out.println("==========================================================================");

            publicCards.dealHand(newDeck.dealTwoCards());
            publicCards.hitMe(newDeck.dealOneCard());
            //drawing the flop
            System.out.println("The Flop:");
            printCommunityCards(publicCards);
            System.out.println();
            //showing the community cards
            showPlayersCards(numPlayers.length, numPlayers);
            System.out.println();
            //Shows players their hands

            betting(numPlayers.length, numPlayers, playersBankClass);
            System.out.println();
            //Betting after the flop

            publicCards.hitMe(newDeck.dealOneCard());
            //drawing the turn
            System.out.println("The Turn:");
            printCommunityCards(publicCards);
            System.out.println();
            //showing the community cards
            showPlayersCards(numPlayers.length, numPlayers);
            System.out.println();
            //Shows players their hands

            betting(numPlayers.length, numPlayers, playersBankClass);
            System.out.println();
            //Betting after the turn

            publicCards.hitMe(newDeck.dealOneCard());
            //drawing the river
            System.out.println("The River:");
            printCommunityCards(publicCards);
            System.out.println();
            //showing the community cards
            showPlayersCards(numPlayers.length, numPlayers);
            System.out.println();
            //Shows players their hands

            betting(numPlayers.length, numPlayers, playersBankClass);
            System.out.println();
            //Betting after the river
            for (int i = 0; i < numPlayers.length; i++) {
                numPlayers[i].setPublicCards(publicCards.getHand());
                numPlayers[i].calculateValue();
                max[i] = numPlayers[i].getValues();
                System.out.println("Player "+(i+1)+"'s value: "+max[i]);
            }
            winningPlayer = winner(max);
            if (winningPlayer.size() == 1) {
                playersBankClass.addToBank(winningPlayer.get(0), playersBankClass.getAllBetsThisRound());

            } else {
                int remainder = playersBankClass.getAllBetsThisRound() % winningPlayer.size();
                int splitWinnings = playersBankClass.getAllBetsThisRound() / winningPlayer.size();
                for (int i = 0; i < remainder; i++) {
                    playersBankClass.addToBank(winningPlayer.get(i), 1);
                }
                for (Integer integer : winningPlayer) {
                    playersBankClass.addToBank(integer, splitWinnings);
                }
            }
            for (int i = 0; i < numPlayers.length; i++) {
                playersBankClass.addToBank(i, - playersBankClass.getCurrentBet(i));
            }

            System.out.println("Deal another round?: ");
            repeat = keyboard.nextLine();
            printBanks(playersBankClass);
            playersBankClass.setBetToZero();
        }
        return repeat;
    }

    public static int anteUp(int numPlayers, int ante, PokerHand hand) {
        Scanner keyboard = new Scanner(System.in);
        int currentBet = 0;
        String stringCurrentBet = "b";
        while (!stringCurrentBet.equalsIgnoreCase("y") && !stringCurrentBet.equalsIgnoreCase("n")) {
            System.out.println("Player " + (numPlayers + 1) + ", would you like to play this round? Type (y) to ante or (n) to fold: ");
            stringCurrentBet = keyboard.nextLine();
        }
        if (stringCurrentBet.equalsIgnoreCase("y")) {
            currentBet = ante;
        } else {
            hand.foldHand(numPlayers);
        }
        System.out.println("==========================================================================");
        return currentBet;
    }

    public static void betting(int playerSize, PokerHand[] numPlayers, BettingPoker playersBankClass)
    {
        Scanner keyboard = new Scanner(System.in);
        for (int i = 1; i < playerSize + 1; i++) {
            if(numPlayers[i-1].getHand().size() > 0 && !numPlayers[i-1].getHand().get(0).getSuit().equalsIgnoreCase("fold"))
            {
                String bettingRound = "d";
                while(!bettingRound.equalsIgnoreCase("r") && !bettingRound.equalsIgnoreCase("c") && !bettingRound.equalsIgnoreCase("f"))
                {
                    System.out.print("Player "+i+", would you like to raise, check, or fold? Type (r) for raise, (c) for check, (f) for fold: ");
                    bettingRound = keyboard.nextLine();
                    System.out.println();
                }
                if(bettingRound.equalsIgnoreCase("r"))
                {
                    boolean allowableBet = false;
                    System.out.print("How much would you like to raise?: ");
                    while (!allowableBet) {
                        bettingRound = keyboard.nextLine();
                        int intBettingRound = Integer.parseInt(bettingRound);
                        allowableBet = playersBankClass.placeBet(i - 1, intBettingRound);
                        if(!allowableBet)
                        {
                            System.out.println("Cannot bet more than your bank ($"+playersBankClass.getPlayerBanks(i -1)+"). Place another bet: ");
                        }
                    }
                    int maxBet = playersBankClass.getCurrentBet(i-1);
                    for (int j = 0; j < playerSize; j++) {
                        if(playersBankClass.getCurrentBet(j) < maxBet && !numPlayers[j].getHand().get(0).getSuit().equalsIgnoreCase("fold"))
                        {
                            bettingRound = "B";
                            while(!bettingRound.equalsIgnoreCase("r") && !bettingRound.equalsIgnoreCase("f"))
                            {
                                System.out.print("Player " + (j+1) + " you need to bet " + (maxBet - playersBankClass.getCurrentBet(j)) + " to continue. Would you like to raise or fold? Type (r) to raise, or (f) to fold: ");
                                bettingRound = keyboard.nextLine();
                                System.out.println();
                            }
                            if(bettingRound.equalsIgnoreCase("f"))
                            {
                                numPlayers[j].foldHand(j);
                                System.out.println("Player "+(j+1)+ " folds ---");
                            }
                            else
                            {
                                allowableBet = playersBankClass.placeBet(j, maxBet - playersBankClass.getCurrentBet(j));
                                if(!allowableBet)
                                {
                                    playersBankClass.allIn(j);
                                }
                            }
                        }
                    }
                    bettingRound = "r";
                }
                if(bettingRound.equalsIgnoreCase("f"))
                {
                    System.out.println("Player "+i+" folds");
                    numPlayers[i-1].foldHand(i-1);
                }
            }
        }
        System.out.println("==========================================================================");
    }

    public static void showPlayersCards(int playerSize, PokerHand[] numPlayers)
    {
        for (int i = 1; i < playerSize + 1; i++) {
            System.out.print("Player " + i + "'s hand: ");
            for (Card card : numPlayers[i - 1].getHand()) {
                System.out.print(card.getRank() + " of " + card.getSuit() + " //");
            }
            System.out.println();
        }
        System.out.println("==========================================================================");
    }

    public static List<Integer> winner(int[][] max)
    {
        List<Integer> winners = new ArrayList<>();
        int tempMax = 0;
        for (int i = 0; i < max.length; i++) {
            for (int j = 0; j < max[i].length ; j++) {
                //go through matrix and find the first instance of a value > 0
                //compare, if they are the same, go down a level
            }
        }
        if(winners.size() > 1)
        {
            System.out.println("Winners: ");
            for(Integer indexOf : winners)
            {
                System.out.println("Player "+(indexOf + 1)+"!");
            }
        }
        else
        {
            System.out.println("Winner: ");
            System.out.println("Player "+(winners.get(0) + 1)+"!");
        }
        System.out.println("==========================================================================");
        return winners;
    }

    public void printCommunityCards(PokerHand publicCards)
    {
        for (Card card : publicCards.getHand()) {
            System.out.print(card.getRank() + " of " + card.getSuit() + " //");
        }
    }
}

