package com.company;

import java.util.Scanner;

public class Dealer {

    private Deck deck;

    public Player getPlayer() {
        return player;
    }

    public Player getHouse() {
        return house;
    }

    private Player player;
    private Player house;

    Scanner scanner = new Scanner(System.in);
    boolean hitOption = true;

    public Dealer() {
        reset();
    }

    private void initializePlayerTotalValues() {
        player.initialize();
        house.initialize();
    }

    public void playGame() {

        initializePlayerTotalValues();

        boolean haveAWinner = false;

        dealCards();
        haveAWinner = checkForBlackJack();

        if (haveAWinner) {
            return;
        }

        player.reportScore();
        house.reportScore();


        while (player.getScore() < 21) {

            int hitOption = 0;
            System.out.println("Would you like to hit? 1. or Stay 2");
            hitOption = scanner.nextInt();
            scanner.nextLine();
            if (hitOption == 1) {

                player.takeCard(deck.getTopCard());
                player.reportScore();

            } else if (hitOption == 2) {
                System.out.println("The player stays!");
                break;
            }

            if (player.getScore() == 21) {
                System.out.println("The Player has a Blackjack! The player won!");
                break;
            } else if (player.getScore() > 21) {
                System.out.println("The player has over 21! The player lost!");
                break;
            }

        }


        while (house.getScore() <= 16 && player.getScore() < 21) {
            System.out.println("The House Hits");
            house.takeCard(deck.getTopCard());
            house.reportScore();

            if (house.getScore() == 21) {
                System.out.println("The Dealer has a Blackjack! The dealer won");
                break;
            } else if (house.getScore() > 21) {
                System.out.println("The house has over 21! The house lost!");
                break;
            } else if (house.getScore() >= 17) {
                System.out.println("The House Stays");
            }
        }

        if (player.getScore() < 21 && house.getScore() < 21) {
            if (player.getScore() >= house.getScore()) {
                System.out.println("Player wins!");
            } else if (house.getScore() > player.getScore()) {
                System.out.println("House wins.");
            }
        }
    }

    public void dealCards() {
        for (int i = 0; i < 2; i++) {
            Card topCard = deck.getTopCard();
            player.takeCard(topCard);

            Card houseTopCard = deck.getTopCard();
            house.takeCard(houseTopCard);

        }
    }

    public void showPlayerHand() {
        player.showCards();
    }

    public void showHouseHand() {
        house.showCards();
    }

    public void shuffle() {
        deck.shuffle();
    }

    public boolean checkForBlackJack() {
        Boolean haveAWinner = false;

        if (player.getScore() == 21 && house.getScore() == 21) {
            System.out.println("The Player and Dealer have a Blackjack! The house wins!");
            haveAWinner = true;
        } else if (player.getScore() == 21) {
            System.out.println("The player has a BlackJack! The player won!");
            haveAWinner = true;
        } else if (house.getScore() == 21) {
            System.out.println("The dealer has a Blackjack! The dealer won");
            haveAWinner = true;
        }
        return haveAWinner;
    }


    public void reset() {
        house = new Player("House");
        player = new Player("Player");
        deck = new Deck();
        deck.buildDeck();
        shuffle();
    }


    public boolean checkForBust() {
        Boolean haveAWinner = false;

        if (player.getScore() > 21 && house.getScore() > 21) {
            System.out.println("The Player and Dealer bust");
            haveAWinner = false;
        } else if (player.getScore() > 21) {
            System.out.println("The player has bust");
            haveAWinner = false;
        } else if (house.getScore() > 21) {
            System.out.println("The dealer has bust");
            haveAWinner = false;
        }
        return haveAWinner;
    }
}