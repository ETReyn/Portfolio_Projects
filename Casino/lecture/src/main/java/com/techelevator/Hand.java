package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    protected List<Card> hand = new ArrayList<>();
    private List<Integer> value = new ArrayList<>();
    private int currentIndex = 0;
    public final String TWO = "TWO";
    public final String THREE = "THREE";
    public final String FOUR = "FOUR";
    public final String FIVE = "FIVE";
    public final String SIX = "SIX";
    public final String SEVEN = "SEVEN";
    public final String EIGHT = "EIGHT";
    public final String NINE = "NINE";
    public final String TEN = "TEN";
    public final String JACK = "JACK";
    public final String QUEEN = "QUEEN";
    public final String KING = "KING";
    public final String ACE = "ACE";
    public final String[] suitIndex = new String[]{"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
    public final String DIAMONDS = "DIAMONDS";
    public final String CLUBS = "CLUBS";
    public final String SPADES = "SPADES";
    public final String HEARTS = "HEARTS";

    public Hand(Deck userDeck){
        value.add(0);
    }

    public void hitMe(Card newCard){hand.add(newCard);}

    public void dealHand(List<Card> newHand){hand = newHand;}

    public List<Card> getHand(){return hand;}

    public void setHand(List<Card> newHand){hand = newHand;}

    public List<Integer> getValue(){return value;}

    public void calculateValue()
    {
        for (int j = currentIndex; j < hand.size(); j++) {
            currentIndex = j;
            switch (hand.get(j).getRank()) {
                case (TWO):
                    for (int i = 0; i < value.size(); i++) {
                        value.set(i, value.get(i) + 2);
                    }
                    break;
                case (THREE):
                    for (int i = 0; i < value.size(); i++) {
                        value.set(i, value.get(i) + 3);
                    }
                    break;
                case (FOUR):
                    for (int i = 0; i < value.size(); i++) {
                        value.set(i, value.get(i) + 4);
                    }
                    break;
                case (FIVE):
                    for (int i = 0; i < value.size(); i++) {
                        value.set(i, value.get(i) + 5);
                    }
                    break;
                case (SIX):
                    for (int i = 0; i < value.size(); i++) {
                        value.set(i, value.get(i) + 6);
                    }
                    break;
                case (SEVEN):
                    for (int i = 0; i < value.size(); i++) {
                        value.set(i, value.get(i) + 7);
                    }
                    break;
                case (EIGHT):
                    for (int i = 0; i < value.size(); i++) {
                        value.set(i, value.get(i) + 8);
                    }
                    break;
                case (NINE):
                    for (int i = 0; i < value.size(); i++) {
                        value.set(i, value.get(i) + 9);
                    }
                    break;
                case (TEN):
                case (KING):
                case (QUEEN):
                case (JACK):
                    for (int i = 0; i < value.size(); i++) {
                        value.set(i, value.get(i) + 10);
                    }
                    break;
                case (ACE):
                    if(value.size() == 1)
                    {
                        value.add(10 + value.get(0));
                    }
                    for (int i = 0; i < value.size(); i++) {
                        value.set(i, value.get(i) + 1);
                    }
                    break;
            }
        }
        for (int i = 0; i < value.size(); i++) {
            if (value.get(i) > 21) {
                value.set(i, -100);
            }
        }
        currentIndex++;
    }

}
