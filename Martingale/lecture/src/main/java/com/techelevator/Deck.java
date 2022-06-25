package com.techelevator;

import java.lang.annotation.Native;
import java.util.*;

public class Deck {

    List<Card> useableDeck = new ArrayList<>();
    List<Card> dealtCards = new ArrayList<>();


    public final String HEARTS = "HEARTS";
    public final String DIAMONDS = "DIAMONDS";
    public final String CLUBS = "CLUBS";
    public final String SPADES = "SPADES";
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
    public final String[] SUIT = {HEARTS, DIAMONDS, CLUBS, SPADES};
    public final String[] RANK = {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};

    public Deck()
    {
        for (int i = 0; i < SUIT.length; i++) {
            for (int j = 0; j < RANK.length; j++) {
                useableDeck.add(new Card(SUIT[i], RANK[j]));
            }
        }
    }

    public Deck(int numberOfDecks)
    {
        for(int k = 0; k < numberOfDecks; k++)
        {
            for (int i = 0; i < SUIT.length; i++) {
                for (int j = 0; j < RANK.length; j++) {
                    useableDeck.add(new Card(SUIT[i], RANK[j]));
                }
            }
        }
    }

    public void shuffleWithoutJokers1()
    {
        List<Card> shuffledDeck = new ArrayList<>();
        Map<Integer, Integer> newPosition = new HashMap<>();
        for (int i = 0; i < useableDeck.size(); i++) {
            Random rand = new Random();
            int indexOf = rand.nextInt(useableDeck.size());
            while(newPosition.containsKey(indexOf))
            {
                indexOf = rand.nextInt(useableDeck.size());
            }
            newPosition.put(indexOf, i);
        }

        for (int i = 0; i < useableDeck.size(); i++) {
            shuffledDeck.add(useableDeck.get(newPosition.get(i)));
        }
        useableDeck = shuffledDeck;
    }

    public void shuffleWithoutJokers()
    {
        Collections.shuffle(useableDeck);
    }


    public void shuffleWithJokers1()
    {
        shuffleWithoutJokers();
        Random rand = new Random();
        int indexOf = rand.nextInt(useableDeck.size());
        useableDeck.add(indexOf, new Card("Joker", "Big Joker"));
        indexOf = rand.nextInt(useableDeck.size());
        useableDeck.add(indexOf, new Card("Joker", "Little Joker"));
    }

    public Card dealOneCard()
    {
        Card dealtCard = new Card(null,  null);
        if(!useableDeck.isEmpty()) {
            dealtCard = useableDeck.get(0);
            dealtCards.add(dealtCard);
            useableDeck.remove(0);
        }
        return dealtCard;
    }

    public List<Card> dealTwoCards()
    {
        List<Card> dealHand = new ArrayList<>();
        dealHand.add(dealOneCard());
        dealHand.add(dealOneCard());
        return dealHand;
    }

}
