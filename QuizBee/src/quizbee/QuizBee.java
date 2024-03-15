/* Name: Khyla Ehza Hondrade
 * Activity: 03 Hands-on Activity 1
 * Description: A Quiz Bee program with Exceptions.
 * Date Submitted: 11/2/2021 
*/
package quizbee;
import java.util.*;

// user-defined exception
class ChoicesOutOfBoundsException extends Exception{
    public ChoicesOutOfBoundsException() {
        super("   Letters must A, B, and C only. Enter your answer again.");
    }
}

// class that is consists of logo(), setQuestions(), and setScores() methods
class QuizBeeResources {
    String[] questions;
    char[] correctAnswers;
    
    public String logo() {
        return "      _                         ____          _        ____              \n" +
"     | |                       / __ \\        (_)      |  _ \\             \n" +
"     | |  __ _ __   __  __ _  | |  | | _   _  _  ____ | |_) |  ___   ___ \n" +
" _   | | / _` |\\ \\ / / / _` | | |  | || | | || ||_  / |  _ <  / _ \\ / _ \\\n" +
"| |__| || (_| | \\ V / | (_| | | |__| || |_| || | / /  | |_) ||  __/|  __/\n" +
" \\____/  \\__,_|  \\_/   \\__,_|  \\___\\_\\ \\__,_||_|/___| |____/  \\___| \\___|\n" +
"                                                                         \n" +
"                                                                         ";
    }
    
    public void setQuestions() {       
        String[] arrayQuestions = {
            "These are notes written by programmers to explain the details of program. Ignored by the compiler.\n"
                + "\t(A). Console       \n\t(B). Comments         \n\t(C). Class",
            "It is a format specifier for single character in printf() method.\n"
                + "\t(A). %c            \n\t(B). %s               \n\t(C). %d",
            "It refers to the conversion of value from specific type to a variable of another type.\n"
                + "\t(A). Measurement   \n\t(B). Data Type        \n\t(C). Type Casting",
            "It is the keyword used in accessing the class in the package within any other programs.\n"
                + "\t(A). get           \n\t(B). return           \n\t(C). import",
            "This allows many meanings to be associated to one method name.\n"
                + "\t(A). Extension     \n\t(B). Dynamic Binding  \n\t(C). Interface",
            "This is a method that can be invoked without using any object.\n"
                + "\t(A). Constant Method\n\t(B). Reference Method \n\t(C). Static Method",
            "A Math class use to get the absolute value of data.\n"
                + "\t(A). abstract()    \n\t(B). absent()         \n\t(C). abs()",
            "A process where function can call itself once or multiple times.\n"
                + "\t(A). Recursion    \n\t(B). Array            \n\t(C). Method",
            "This is also called looping.\n"
                + "\t(A). Iteration      \n\t(B). Do-while         \n\t(C). Instantiation",
            "An algorithm which the last element added is the first element that will removed of retrieved.\n"
                + "\t(A). Array         \n\t(B). Stacks           \n\t(C). Queues",
        };
        this.questions = arrayQuestions;     
    }
    
    public int setScores(char[] userAns) {
        char[] cAns = {'B', 'A', 'C', 'C', 'B', 'C', 'C', 'A', 'A', 'B'}; // correct answers
        int score = 0;       
        correctAnswers = cAns;
        
        // checks if the user answers are equal to correct answers
        for (int item = 0; item < cAns.length; item++) {
            Character cA = cAns[item];
            Character uA = Character.toUpperCase(userAns[item]); // convert to uppercase
            if (cA.equals(uA)) {
                score++;
            }
        }
        return score;
    }    
}

public class QuizBee {

    public static void main(String[] args) {
        QuizBeeResources qObj = new QuizBeeResources();
        Scanner userAns = new Scanner(System.in);
        char[] listOfUserAnswers = new char[10];
        boolean willRepeat = true;
        qObj.setQuestions();
        System.out.println(qObj.logo());
        
        for (int index = 0; index < qObj.questions.length; index++) {
        System.out.printf("%d. %s\n", (index + 1), qObj.questions[index]);
            do {                
                System.out.print("   Your Answer: "); 
                try {                      
                    String userString = userAns.nextLine();                   
                    if (String.valueOf(userString).isEmpty()) { // if the user input is blank
                        throw new NullPointerException();
                    }                
                    char userAnswer = userString.charAt(0);
                    if (Character.toUpperCase(userAnswer) > 'C' ) { // if the letter is not a, b, or c
                        throw new ChoicesOutOfBoundsException();
                    }               
                    if (!(Character.isLetter(userAnswer))) {
                        throw new InputMismatchException(); // if the user input is invalid
                    }
                    listOfUserAnswers[index] = userAnswer;
                    willRepeat = false;
                    
                // three catches for exception     
                } catch (NullPointerException nullEx) {
                    System.out.println("   Your input is blank. Enter your answer again.");
                    willRepeat = true;
                } catch (ChoicesOutOfBoundsException choicesEx) {
                    System.out.println(choicesEx.getMessage());
                    willRepeat = true;
                } catch (InputMismatchException inputEx) {
                    System.out.println("   Invalid Input. Enter your answer again.");
                    willRepeat = true;
                }            
            } while (willRepeat);  
            System.out.println();
        }
        
        // Printing the result
        System.out.println("--------------- RESULT ---------------");
        System.out.println("You made it! You got " + qObj.setScores(listOfUserAnswers) + " out of " + qObj.questions.length + "!");
        System.out.println("Your Answers: " + Arrays.toString(listOfUserAnswers));
        System.out.println("Correct Answers: " + Arrays.toString(qObj.correctAnswers));
    }
    
}
