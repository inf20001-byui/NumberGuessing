// Christopher Infante
// CSE 310 - Winter 2023

// This program has the user guess a number radomly picked by the system.

/* Import the Scanner class.  
   This class is used to read the input of primitive types like int, double, long, short, float, and byte.
*/
import java.util.Scanner;
/* Import the ArrayList class.  
   This class is used to create a resizable array.
*/
import java.util.ArrayList;
/* Import the Random number gernerator class 
   This class is used to generate random numbers
*/
import java.util.Random;

public class Main extends Color{ // Using extends to inherit the Color class from Color.java
    public static void main(String[] args) {
        // Set variable to play game again
        boolean PLAYAGAIN = true;

        // Create a Random object from the Random class
        Random newNumber = new Random(); 

         // Assign random number between 0 and 100 to the variable "randomNumber"
        int randomNumber = newNumber.nextInt(100);
        
        // Create an ArrayList to store the numbers guessed
        ArrayList<Integer> numbersGuessed = new ArrayList<Integer>(); 

        //Used for testing to show the random number - remove before using!
        System.out.println(randomNumber); 

        // Initialize a Scanner object from the Scanner class
        Scanner userInput = new Scanner(System.in); 
        
        // Initialize the userGuess variable
        int userGuess; 

        // Introduction to the game
        System.out.println();
        System.out.println(YELLOW + "Welcome to the Chris' Number Guessing Game!" + RESET);
        System.out.println(YELLOW + "Your job is the guess the number I'm thinking about which is between 1 and 100." + RESET);
        System.out.println(YELLOW + "You will see the list of numbers you have guessed as you go along." + RESET);
        System.out.println();
        System.out.println(YELLOW + "Good luck, you're going to need it!" + RESET);
        System.out.println();        

        // Loop to keep the game going until the user guesses the correct number
        do {
            System.out.println();
            System.out.print(RESET + "What number do you want to guess? ");
            // Assign the user's input to the variable "userGuess"
            userGuess = userInput.nextInt(); 

            //Check to see if the number is out of the range of 1-100 before proceeding
            if (userGuess > 100) {
                System.out.println(RED + "Please guess a number between 1 and 100" + RESET); 
            } 
            else if (userGuess <= 100) {
                // Add the guessed number to our ArrayList
                numbersGuessed.add(userGuess); 
           
                // Logic to test if the guessed number was correct and displays the number of tries it took to get correct
                if (userGuess == randomNumber) {
                    System.out.println("You guessed " +  ANSI_GREEN_BACKGROUND + randomNumber + ANSI_BLACK_BACKGROUND + " which is correct!");
                    System.out.println(BLUE + "It took you " + numbersGuessed.size() + " guesses to get the correct number." + RESET);
                    System.out.println();
                    System.out.println();

                    // Ask the user if they want to play again
                    System.out.print(YELLOW + "Would you like to play again? (y/n) " + RESET);

                    // Assign the user's input to the variable "playAgainInput"
                    String playAgainInput = userInput.next();
                    System.out.println();

                    // Check to see if the user responded yes to play again regardless of case
                    if (playAgainInput.equalsIgnoreCase("y")) {
                        PLAYAGAIN = true; // Set the playAgain variable to true                        
                    }

                    // Check to see if the user responded no to play again regardless of case
                    else if (playAgainInput.equalsIgnoreCase("n")) {
                        PLAYAGAIN = false; // Set the playAgain variable to false   
                    }

                    // If the user did not enter a valid input
                    else {
                        System.out.println(RED + "Invalid Input, please enter Y or N !" + RESET); //The input is not a number
                    }
                }

                // Logic to test it the guessed number was too high or too low and then shows the numbers guessed
                else if (userGuess > randomNumber) {
                    System.out.println("You guessed " + ANSI_RED_BACKGROUND + userGuess + ANSI_BLACK_BACKGROUND + " which is too high!");
                    System.out.println(CYAN + "You have guessed " + numbersGuessed + " so far." + RESET);
                    System.out.println();
                }
                else if (userGuess < randomNumber) {
                    System.out.println("You guessed " + ANSI_RED_BACKGROUND + userGuess + ANSI_BLACK_BACKGROUND + " which is too low!");
                    System.out.println(CYAN + "You have guessed " + numbersGuessed + " so far." + RESET);
                    System.out.println();
                }
                else {
                    System.out.println(RED + "Thank you for playing!" + RESET); 
                }
            }
        }
        // Loop until the user answers no to playing again
        while (PLAYAGAIN == true); 

        System.out.println(RED + "Thank you for playing!" + RESET); 
        System.out.println();

        // Close the Scanner object to free up the resource
        userInput.close(); 
        
    }
}

