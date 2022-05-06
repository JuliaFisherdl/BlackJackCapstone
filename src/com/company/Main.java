package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
        System.out.println("Welcome to Blackjack");

        Dealer dealer = new Dealer();
        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;

        while (keepPlaying) {
            int playOption = 0;
            System.out.println("Would you like to play? 1. Yes or 2 No");
            playOption = scanner.nextInt();
            scanner.nextLine();
            if (playOption == 1) {
                dealer.playGame();

            } else if (playOption == 2) {
                System.out.println("Thanks for playing BlackJack.");
                break;
            } else {
                System.out.println("Invalid option. 1) Yes 2) No");
            }
        }
    }
}










