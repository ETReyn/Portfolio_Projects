package com.techelevator;

public class Card {

    private String suit;
    private String rank;
    boolean faceUp;

    public Card(String userSuit, String userRank)
    {
        suit = userSuit;
        rank = userRank;
        faceUp = false;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Card(String userSuit, String userRank, boolean cardState)
    {
        suit = userSuit;
        rank = userRank;
        faceUp = cardState;
    }
    public void flip()
    {
        faceUp = !faceUp;
    }

    public String getSuit(){return suit;}

    public String getRank(){return rank;}

}
