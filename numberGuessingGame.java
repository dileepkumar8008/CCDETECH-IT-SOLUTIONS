package CodTechSolutions;

import java.util.Random;
import java.util.Scanner;

public class numberGuessingGame {
	public static void main(String[] args)
	   {
		        Scanner sc = new Scanner(System.in);
		        Random random = new Random();
		        int lowerBound = 1;
		        int upperBound = 100;
		        int randomNumber = random.nextInt(upperBound-lowerBound+1)+lowerBound;
		        int maxAttempts = 10;
		        int attempts = 0;
		        int guess;
		        System.out.println("Welcome to the Number Guessing Game!");
		        System.out.println("I have chosen a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");
		        while (attempts < maxAttempts)
		        {
		            System.out.println("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
		            guess = sc.nextInt();
		            
		            if (guess < lowerBound || guess > upperBound)
		            {
		                System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
		                continue;
		            }
		            if (guess == randomNumber)
		            {
		                System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
		                break;
		            }
		            else if (guess < randomNumber)
		            {
		                System.out.println("Too low! Try again.");
		            }
		            else
		            {
		                System.out.println("Too high! Try again.");
		            }
		            attempts++;
		        }
		        if (attempts == maxAttempts)
		        {
		            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
		        }
		        sc.close();
}
}
