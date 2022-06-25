package com.techelevator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        BlackjackApplication bA = new BlackjackApplication(keyboard);
        TexasHoldemApplication tA = new TexasHoldemApplication(keyboard);
        String repeat = "y";
        while(repeat.equals("y"))
        {
            repeat = tA.controlFlow();
        }
    }
}
