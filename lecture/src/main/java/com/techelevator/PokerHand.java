package com.techelevator;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PokerHand extends Hand {

    private List<Card> publicCards = new ArrayList<>();
    private int values;
    private int[] valArray = new int[10];

    public PokerHand(Deck userDeck) {
        super(userDeck);
    }

    public int[] getValues()
    {
        return valArray;
    }

    public void foldHand(int playerNumber) {
        Card newCard = new Card("Fold", "Fold");
        hand.set(0, newCard);
        hand.set(1, newCard);
    }

    public void setPublicCards(List<Card> publicCards) {
        this.publicCards = publicCards;
    }

    @Override
    public void calculateValue() {
        int[] suitCount = new int[4]; //0 - Hearts, 1 - Diamonds, 2 - Clubs, 3 - Spades
        int[] rankCount = new int[13];
        values = 0;
        suitCount = switchSuits(hand, suitCount);
        suitCount = switchSuits(publicCards, suitCount);

        rankCount = switchRank(hand, rankCount);
        rankCount = switchRank(publicCards, rankCount);
        List<Integer> pairCount = pair(rankCount);

        if(fourOfAKind(rankCount) > -1)
        {
            //values = 700000 + fourOfAKind(rankCount);
            valArray[1] = fourOfAKind(rankCount);
            System.out.println("fours");
        }
        else if (flush(suitCount) > -1)
        {
            //values = 500000 + flush(suitCount);
            valArray[2] = flush(suitCount);
            System.out.println("flush");
            if(straight(rankCount) > -1)
            {
                if(straightFlush() > 4)
                {
                    //values = 800000 + straightFlush();
                    valArray[0] = straightFlush();
                    System.out.println("straight flush");
                }
            }
        }
        else if (straight(rankCount) > 5)
        {
            //values = 400000 + straight(rankCount);
            valArray[4] = straight(rankCount);
            System.out.println("straight");
        }
        else if(trips(rankCount) > -1)
        {
            if(pairCount.size() > 0)
            {
                //values = 300000 + trips(rankCount) * 100;
                //values += pairCount.get(0);
                valArray[5] = (100 * trips(rankCount)) + pairCount.get(0);
                System.out.println("full house");
            }
            else{
                //values = 300000 + trips(rankCount);
                valArray[6] = trips(rankCount);
                System.out.println("trips");
            }
        }
        else if(pairCount.size() > 0)
        {
            if(pairCount.size() > 1)
            {
                //values = 200000 + pairCount.get(0) * 100;
                //values += pairCount.get(1);
                valArray[7] = (pairCount.get(0) * 100) + pairCount.get(1);
                System.out.println("two pair");
            }
            else
            {
                valArray[8] = pairCount.get(0);
                values = 1000 + pairCount.get(0);
                System.out.println("pair");
            }
        }
        else
        {
            valArray[9] = highCardValue(rankCount);
            //values = highCardValue(rankCount);
            System.out.println("high");
        }
    }

    public int highCardValue(int[] ranked) {
        int maxCard = 0;
        for (int i = ranked.length - 1; i >= 0; i--) {
            if (maxCard < ranked[i]) {
                return maxCard;
            }
        }
        return 0;
    }

    public List<Integer> pair(int[] ranked) {
        List<Integer> numOfPairs = new ArrayList<>();
        for (int i = ranked.length - 1; i >= 0; i--) {
            if (ranked[i] == 2) {
                numOfPairs.add(i);
            }
        }
        return numOfPairs;
    }

    public int trips(int[] ranked) {
        for (int i = ranked.length - 1; i >= 0; i--) {
            if (ranked[i] == 3) {
                return i;
            }
        }
        return -1;
    }

    public int flush(int[] suits) {
        int highCard = -1;
        for (int i = 0; i < suits.length; i++) {
            if (suits[i] == 5) {
                for (Card card : hand) {
                    highCard = switchRankFlush(suitIndex[i], card, highCard);
                }
                for (Card card : publicCards) {
                    highCard = switchRankFlush(suitIndex[i], card, highCard);
                }
            }
        }

        return highCard;
    }

    public int straight(int[] rank) {
        int highCard = 12;
        int count = 1;
        for (int i = rank.length - 1; i >= 0; i--) {
            if (rank[i] > 0) {
                count++;
                if (count == 6) {
                    break;
                }
            } else {
                count = 1;
                highCard = i - 1;
            }
        }
        return highCard;
    }

/*    public List<Integer> fullHouse(int[] ranked) {
        List<Integer> triplePair = new ArrayList<>();
        List<Integer> pair = pair(ranked);
        int trips = trips(ranked);
        if (pair.size() > 0 && trips > -1) {
            triplePair.add(trips);
            triplePair.add(pair.get(0));
        }
        return triplePair;
    }*/

    public int fourOfAKind(int[] ranked) {
        for (int i = ranked.length - 1; i >= 0; i--) {
            if (ranked[i] == 4) {
                return i;
            }
        }
        return -1;
    }

    public int[] switchSuits(List<Card> counting, int[] suitCount) {

        for (Card card : counting) {
            switch (card.getSuit()) {
                case (HEARTS):
                    suitCount[0]++;
                    break;
                case (DIAMONDS):
                    suitCount[1]++;
                    break;
                case (CLUBS):
                    suitCount[2]++;
                    break;
                case (SPADES):
                    suitCount[3]++;
                    break;
            }
        }
        return suitCount;
    }

    public int[] switchRank(List<Card> counting, int[] rankCount) {
        for (Card card : counting) {
            switch (card.getRank()) {
                case (TWO):
                    rankCount[0]++;
                    break;
                case (THREE):
                    rankCount[1]++;
                    break;
                case (FOUR):
                    rankCount[2]++;
                    break;
                case (FIVE):
                    rankCount[3]++;
                    break;
                case (SIX):
                    rankCount[4]++;
                    break;
                case (SEVEN):
                    rankCount[5]++;
                    break;
                case (EIGHT):
                    rankCount[6]++;
                    break;
                case (NINE):
                    rankCount[7]++;
                    break;
                case (TEN):
                    rankCount[8]++;
                    break;
                case (JACK):
                    rankCount[9]++;
                    break;
                case (QUEEN):
                    rankCount[10]++;
                    break;
                case (KING):
                    rankCount[11]++;
                    break;
                case (ACE):
                    rankCount[12]++;
                    break;
            }
        }
        return rankCount;
    }

    public int straightFlush() {
        int[][] fullInfo = new int[4][13];
        int count = 1;
        int highCard = -1;
        for (int i = 0; i < fullInfo.length; i++) {
            switchStrightFlush(suitIndex[i], hand, fullInfo[i]);
            switchStrightFlush(suitIndex[i], publicCards, fullInfo[i]);

            for (int j = fullInfo[i].length - 1; j >= 0; j--) {
                if (fullInfo[i][j] > 0) {
                    count++;
                    if (count == 6) {
                        break;
                    }
                } else {
                    count = 1;
                    highCard =  j;
                }
                count = 1;
            }
            if(count == 6)
            {
                break;
            }
        }
        return highCard;
    }

    public void switchStrightFlush(String suit, List<Card> sampleHand, int[] straightFlush) {
        for(Card card : sampleHand)
        {
            if (card.getSuit().equalsIgnoreCase(suit)) {
                switch (card.getRank()) {
                    case (ACE):
                        straightFlush[12]++;
                        break;
                    case (KING):
                        straightFlush[11]++;
                        break;
                    case (QUEEN):
                        straightFlush[10]++;
                        break;
                    case (JACK):
                        straightFlush[9]++;
                        break;
                    case (TEN):
                        straightFlush[8]++;
                        break;
                    case (NINE):
                        straightFlush[7]++;
                        break;
                    case (EIGHT):
                        straightFlush[6]++;
                        break;
                    case (SEVEN):
                        straightFlush[5]++;
                        break;
                    case (SIX):
                        straightFlush[4]++;
                        break;
                    case (FIVE):
                        straightFlush[3]++;
                        break;
                    case (FOUR):
                        straightFlush[2]++;
                        break;
                    case (THREE):
                        straightFlush[1]++;
                        break;
                    case (TWO):
                        straightFlush[0]++;

                        break;
                }
            }
        }
    }

    public int switchRankFlush(String suit, Card card, int highCard) {
        if (card.getSuit().equalsIgnoreCase(suit)) {
            switch (card.getRank()) {
                case (ACE):
                    highCard = 12;
                    break;
                case (KING):
                    if (highCard < 11) {
                        highCard = 11;
                    }
                    break;
                case (QUEEN):
                    if (highCard < 10) {
                        highCard = 10;
                    }
                    break;
                case (JACK):
                    if (highCard < 9) {
                        highCard = 9;
                    }
                    break;
                case (TEN):
                    if (highCard < 8) {
                        highCard = 8;
                    }
                    break;
                case (NINE):
                    if (highCard < 7) {
                        highCard = 7;
                    }
                    break;
                case (EIGHT):
                    if (highCard < 6) {
                        highCard = 6;
                    }
                    break;
                case (SEVEN):
                    if (highCard < 5) {
                        highCard = 5;
                    }
                    break;
                case (SIX):
                    if (highCard < 4) {
                        highCard = 4;
                    }
                    break;
                case (FIVE):
                    if (highCard < 3) {
                        highCard = 3;
                    }
                    break;
                case (FOUR):
                    if (highCard < 2) {
                        highCard = 2;
                    }
                    break;
                case (THREE):
                    if (highCard < 1) {
                        highCard = 1;
                    }
                    break;
                case (TWO):
                    if (highCard < 0) {
                        highCard = 0;
                    }
                    break;
            }
        }
        return highCard;
    }

}
