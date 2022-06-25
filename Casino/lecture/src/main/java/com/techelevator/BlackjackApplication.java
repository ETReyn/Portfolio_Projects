package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackApplication extends GameClass {
    Betting playersBankClass;
    Scanner keyboard;

    public BlackjackApplication(Scanner keyboard) {
        this.keyboard = keyboard;
    }

    public String controlFlow() {
        String repeat = "y";
        List<Integer> winningPlayer = new ArrayList<>();

        Deck newDeck = new Deck(askUserForDeckSize());
        //Creates the shoe with the required number of decks

        Hand[] numPlayers = new Hand[askUserForNumberOfPlayers()];
        //Creates an array of hands to simulate the number of players

        playersBankClass = getBanks(numPlayers.length, keyboard);
        //Creates each player's bank

        int[] max = getMax(repeat, newDeck, numPlayers, keyboard);
        //Allows each player to hit or stay, then tallies up the values of each player's hand
        getResults(max);
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
            playersBankClass.addToBank(i, -playersBankClass.getCurrentBet(i));
        }
        //Divides the bets this round to the winning players
        System.out.println("==========================================================================");
        System.out.println("Type 'y' to play again: ");
        repeat = keyboard.nextLine();
        printBanks(playersBankClass);
        playersBankClass.setBetToZero();
        //Loop that will keep going as long as the players keep playing
        System.out.println("Player " + (winningPlayer.get(0) + 1) + " was the winner!");
        return repeat;
    }

    public static void getResults(int[] max) {
        System.out.println("Results:");
        for (int i = 1; i < max.length + 1; i++) {
            if (max[i - 1] == 0) {
                System.out.println("xx Player " + i + " went over 21 xx");
            } else {
                System.out.println("Player " + i + "'s score was " + max[i - 1]);
            }
        }
    }

    public static String playerHandValue(Hand numPlayers) {
        int count = 0;
        String blackJack = "";

        for (int j = 0; j < numPlayers.getValue().size(); j++) {
            if (numPlayers.getValue().get(j) < 0) {
                count++;
            }
            if (numPlayers.getValue().get(j) == 21) {
                blackJack = "Blackjack";
                System.out.println("Blackjack!!!!!");
                break;
            }
        }
        if (count == numPlayers.getValue().size()) {
            blackJack = "Bust";
            System.out.println("Player went over 21!");
        }
        return blackJack;
    }

    public int[] getMax(String repeat, Deck newDeck, Hand[] numPlayers, Scanner keyboard) {
        int[] max = new int[numPlayers.length];
        shuffleDeck(newDeck, numPlayers);
        placeBet(numPlayers);

        for (int i = 1; i < numPlayers.length + 1; i++) {
            if (playersBankClass.getPlayerBanks(i - 1) <= 0) {
                continue;
            }
            String hitOrStay = initialHand(i, numPlayers);
            String blackJack = playerHandValue(numPlayers[i - 1]);
            while (hitOrStay.equalsIgnoreCase("h") && !blackJack.equalsIgnoreCase("blackjack")) {
                numPlayers[i - 1].hitMe(newDeck.dealOneCard());
                numPlayers[i - 1].calculateValue();
                hitOrStay = playerHandValue(numPlayers[i - 1]);

                System.out.print("Player " + i + "'s hand: ");
                for (Card card : numPlayers[i - 1].getHand()) {
                    System.out.print(card.getRank() + " of " + card.getSuit() + " //");
                }
                System.out.println();
                if (hitOrStay.equalsIgnoreCase("blackjack")) {
                    break;
                } else if (hitOrStay.equalsIgnoreCase("Bust")) {
                    break;
                }
                System.out.println("Hand value for player " + i + ": " + numPlayers[i - 1].getValue());
                System.out.println("Type h to hit, or anything else to stay");
                hitOrStay = keyboard.nextLine();
            }
            for (Integer value : numPlayers[i - 1].getValue()) {
                if (value > max[i - 1]) {
                    max[i - 1] = value;
                }
            }
            System.out.println();
            if (!hitOrStay.equalsIgnoreCase("bust") && !hitOrStay.equalsIgnoreCase("blackjack")) {
                System.out.println("The value of player " + i + "'s hand is: " + max[i - 1]);

            }
        }

        return max;
    }

    public static List<Integer> winner(int[] max) {
        List<Integer> winners = new ArrayList<>();
        int tempMax = 0;
        for (int userMax : max) {
            if (tempMax < userMax) {
                tempMax = userMax;
            }
        }
        for (int i = 0; i < max.length; i++) {
            if (max[i] == tempMax) {
                winners.add(i);
            }
        }
        if (winners.size() > 1) {
            System.out.println("Winners: ");
            for (Integer indexOf : winners) {
                System.out.println("Player " + (indexOf + 1) + "!");
            }
        } else {
            System.out.println("Winner: ");
            System.out.println("Player " + (winners.get(0) + 1) + "!");
        }
        return winners;
    }

    public boolean checkForGameWinner() {
        int count = 0;
        for (Integer ints : playersBankClass.getPlayerBanks()) {
            if (ints <= 0) {
                count++;
            }
        }
        if (count == playersBankClass.getPlayerBanks().size() - 1) {
            return true;
        }
        return false;
    }

    public void shuffleDeck(Deck newDeck, Hand[] numPlayers) {
        System.out.println("==========================================================================");
        System.out.println("Shuffling deck(s) and dealing cards...");
        newDeck.shuffleWithoutJokers();
        for (int i = 0; i < numPlayers.length; i++) {
            if (playersBankClass.getPlayerBanks(i) > 0) {
                numPlayers[i] = new Hand(newDeck);
                numPlayers[i].dealHand(newDeck.dealTwoCards());
            }
        }
        //Shuffles deck and then deals two cards to each player
        System.out.println("==========================================================================");
    }

    public void placeBet(Hand[] numPlayers) {
        for (int i = 0; i < numPlayers.length; i++) {
            if (playersBankClass.getPlayerBanks(i) <= 0) {
                continue;
            }
            boolean allowableBet = false;
            while (!allowableBet) {
                System.out.print("Player " + (i + 1) + ", what is your bet?: ");
                String playerBet = keyboard.nextLine();
                int intPlayerBet = Integer.parseInt(playerBet);
                allowableBet = playersBankClass.placeBet(i, intPlayerBet);
            }

        }
        System.out.println("==========================================================================");
        //Each player places a bet
    }

    public String initialHand(int i, Hand[] numPlayers) {
        System.out.print("Player " + i + "'s hand: ");
        for (Card card : numPlayers[i - 1].getHand()) {
            System.out.print(card.getRank() + " of " + card.getSuit() + " //");
        }
        System.out.println();
        numPlayers[i - 1].calculateValue();
        System.out.println("Hand value for player " + i + ": " + numPlayers[i - 1].getValue());
        System.out.println("Type h to hit, or anything else to stay");
        return keyboard.nextLine();
    }
}


