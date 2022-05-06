package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    String[] suits = {"Spades", "Clubs", "Diamonds", "Hearts"};
    String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    List<Card> cards = new ArrayList<Card>();

    public void buildDeck() {

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                int value;
                if (rank[j] == "Jack" || rank[j] == "Queen" || rank[j] == "King") {
                    value = 10;
                } else if (rank[j] == "Ace") {
                    value = 11;
                } else value = Integer.parseInt(rank[j]);
                Card card = new Card(suits[i], rank[j], value);
                cards.add(card);
            }
        }
    }

    public void describeDeck() {
        for (Card card : cards) {
            card.describeCard();
        }
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return new ArrayList<Card>(cards);
    }

    public Card getTopCard() {
        return cards.remove(0);
    }
}




