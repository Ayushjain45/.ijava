import java.util.Random;
import java.util.Scanner;

public class UniqueNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int totalScore = 0;
        boolean playAgain = true;

        
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String YELLOW = "\u001B[33m";
        final String CYAN = "\u001B[36m"; 

        System.out.println(CYAN + "=== Welcome to the Unique Number Guessing Game! ===" + RESET);

        while (playAgain) {
            int min = 1, max = 100;
            int target = rand.nextInt(max - min + 1) + min;
            int attempts = 0;
            int maxAttempts = 10;

            System.out.println("\nI have picked a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts. Let's go!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println(RED + "Invalid input! Please enter a number." + RESET);
                    continue;
                }

                attempts++;

                if (guess == target) {
                    System.out.println(GREEN + "🎉 Correct! You guessed the number in " + attempts + " attempts!" + RESET);
                    totalScore += (maxAttempts - attempts + 1) * 10; // Score formula
                    break;
                } else if (guess > target) {
                    System.out.println(YELLOW + "Too high!" + RESET);
                    max = Math.min(max, guess - 1);
                } else {
                    System.out.println(YELLOW + "Too low!" + RESET);
                    min = Math.max(min, guess + 1);
                }

                System.out.println("New range: " + min + " to " + max);
            }

            if (attempts == maxAttempts) {
                System.out.println(RED + "❌ Out of attempts! The number was " + target + "." + RESET);
            }

            System.out.println(CYAN + "Your current total score: " + totalScore + RESET);

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = sc.nextLine().equalsIgnoreCase("yes");
        }

        System.out.println(GREEN + "Thanks for playing! Your final score: " + totalScore + RESET);
        sc.close();
    }
}
