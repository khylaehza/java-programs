/* Name: Khyla Ehza Hondrade
 * Activity: 05 Hands-on Activity 1
 * Description: A Guessing Game with Exceptions
 * Date Submitted: 10/29/2021 
*/
package guessgame;
import java.util.Scanner;
import java.util.InputMismatchException;

// User-defined Exception
class OutOfRangeException extends Exception{
    public OutOfRangeException() {
        super("Out of range.");
    }
}

// Printing information
class GuessingGame {
    boolean willRepeat = true;    
    public void GuessingGame(int guessNum, int randomNum, int userScore) {
        String highOrLow, equalOrNot;     
        
        // Using ternary operators for displays
        highOrLow = (guessNum > randomNum) ? "Too high. Please try again." : "Too low. Please try again.";
        equalOrNot = (guessNum == randomNum) ? "Congratulations! You got it in " + userScore + " attempt(s)!" : highOrLow;               
        System.out.println(equalOrNot); 
            
        willRepeat = (guessNum != randomNum);           
    }
}

public class GuessGame {
    public static void main(String[] args) {
        Scanner guessingScanner = new Scanner(System.in);  
        GuessingGame obj = new GuessingGame();  
        int randomNum, userGuess, userAttempts = 0;
        
        do {
            randomNum = (int)(Math.random() * 50 + 1);
            System.out.println("Guess a number from 1 to 50!"); 
            
            try {
                do {
                    System.out.print("Enter your guess number: ");
                    userGuess = guessingScanner.nextInt();
                    
                    if (userGuess > 50 || userGuess < 1) {
                        throw new OutOfRangeException();
                    }
                    userAttempts++;
                    // calling the method
                    obj.GuessingGame(userGuess, randomNum, userAttempts);
                                  
                } while(obj.willRepeat);               
            } catch(InputMismatchException formatEx) {
                System.out.println("Invalid input. "); 
            }
             catch(OutOfRangeException outEx) {
                        System.out.println("Out of range.");
            } finally {
                // just to prevent from having infinite loop
                guessingScanner.nextLine();
                System.out.println();
            }
        } while(obj.willRepeat);
    }   
}
