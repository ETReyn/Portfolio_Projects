package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameClass {

    public String controlFlow(){return "";}

    public void printBanks(Betting playersBankClass)
    {
        for(Integer ints : playersBankClass.getPlayerBanks())
        {
            System.out.println(ints);
        }
    }

    public int askUserForDeckSize()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the number of decks that will be used (1 - 6): ");
        String stringDecks = keyboard.nextLine();
        int intStringDecks = Integer.parseInt(stringDecks);
        while (intStringDecks > 6 || intStringDecks < 1)
        {
            System.out.print("Please enter the number of decks that will be used (1 - 6): ");
            stringDecks = keyboard.nextLine();
            intStringDecks = Integer.parseInt(stringDecks);
        }
        System.out.println("==========================================================================");

        return intStringDecks;
    }

    public int askUserForNumberOfPlayers()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the number of players that will be in the game (2 - 6): ");
        String stringPlayers = keyboard.nextLine();
        int intStringPlayers = Integer.parseInt(stringPlayers);
        while (intStringPlayers > 6 || intStringPlayers < 2)
        {
            System.out.print("Please enter the number of players that will be in the game (2 - 6): ");
            stringPlayers = keyboard.nextLine();
            intStringPlayers = Integer.parseInt(stringPlayers);
        }
        System.out.println("==========================================================================");

        return intStringPlayers;
    }

    public Betting getBanks(int numPlayers, Scanner keyboard)
    {
        List<Integer> playerBank = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("What is the value of player "+(i + 1)+"'s bank?: ");
            String bankVal = keyboard.nextLine();
            int intBankVal = Integer.parseInt(bankVal);
            playerBank.add(intBankVal);
        }
        return new Betting(playerBank);

    }

}
