import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int totalAttempts = 0;
        int totalRoundsWon = 0;
        boolean playAgain = true;  
        while (playAgain) {
            rounds++;
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("Round " + rounds + ": Guess the number between " + lowerBound + " and " + upperBound); 
            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int guess = scanner.nextInt();
                scanner.nextLine(); // Consume newline character 
                if (guess < lowerBound || guess > upperBound) {
                    System.out.println("Invalid guess. Please enter a number within the range.");
                    continue;
                }  
                attempts++;
                totalAttempts++;     
                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number (" + targetNumber + ") in " + attempts + " attempts.");
                    totalRoundsWon++;
                    guessedCorrectly = true;
                } else if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Round " + rounds + " over. The correct number was: " + targetNumber);
            }  
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.nextLine().toLowerCase();  
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }
        System.out.println("\n=== Game Summary ===");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Total Rounds Won: " + totalRoundsWon);
        System.out.println("Total Attempts: " + totalAttempts);
        scanner.close();
    }
}
