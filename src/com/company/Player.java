package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;


    public List<Card> getHand() {
        return hand;
    }

    private List<Card> hand = new ArrayList<>();
    private int score;

    public Player(String name) {
        this.name = name;
    }

    private void updateScore() {
        this.score = 0;
        for (Card card: hand) {
            this.score += card.getValue();
        }
    }

    public int getScore() {
        return score;
    }

    public void initialize() {
        this.hand.clear();
        this.score = 0;
    }

    public void takeCard(final Card card) {
        hand.add(card);
        updateScore();

        System.out.println(getName() +  " given card:");
        card.describeCard();
    }

    public void showCards() {
        for (Card card : hand) {
            card.describeCard();
        }
    }

    public String getName() {
        return name;
    }

    public void reportScore() {
        System.out.println(this.name + " value is " + getScore());
    }
}


