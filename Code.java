package ArtifactOne;

import java.util.Scanner;
import java.util.Random;

public class NumberGuesserGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(1000) + 1; // Random number between 1-1000
            int previousGuess = -1;
            boolean numberGuessed = false;

            System.out.println("I've picked a number between 1 and 1000. Can you guess it?");

            while (!numberGuessed) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the number!");
                    numberGuessed = true;
                } else {
                    if (previousGuess != -1) {
                        int prevDistance = Math.abs(previousGuess - targetNumber);
                        int currentDistance = Math.abs(userGuess - targetNumber);

                        if (currentDistance < prevDistance) {
                            System.out.println("You're getting closer!");
                        } else {
                            System.out.println("You're getting farther away.");
                        }
                    }
                    if (userGuess < targetNumber) {
                        System.out.println("Too low!");
                    } else {
                        System.out.println("Too high!");
                    }
                }

                previousGuess = userGuess; // Update the previous guess
            }

            System.out.print("Would you like to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}
