import java.util.Random;
import java.util.Scanner;

public class Game {
    public static boolean play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 5;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game! If you guess the correct number in 5 tries you get $100");
        System.out.println("I'm thinking of a number between 1 and 5.");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Try a higher number.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Try a lower number.");
            } else {
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                hasGuessedCorrectly = true;
            }
        }
        
        if ( attempts <= 5){
            return true;
        } else {
            return false;
        }
    }
}
