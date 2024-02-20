/*
 * Name: Khyla Ehza Hondrade
 * Activity: 01 Hands-on Activity 2
 * Description: A simple object-oriented program composing non-static and static methods with parameter, input, and outputs.
 * Additions: Try and catch exceptions
 * Date Submitted: 9/30/2021
 */
package staticandnonstaticmethods;
import java.util.Scanner;

public class StaticAndNonStaticMethods {

     // non-static method
    public void showNumberPlus10(int num) {
        System.out.printf("%d plus 10 is %d.\n", num, num + 10);
    }
    
    // non-static method
    public void showNumberPlus100(int num) {
        System.out.printf("%d plus 100 is %d.\n", num, num + 100);
    }
    
    // static method
    public static void showNumberPlus1000(int num) {
        System.out.printf("%d plus 1000 is %d.\n", num, num + 1000);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userNum;
        
        try {
            System.out.print("Enter an integer: ");
            userNum = input.nextInt();
            
            // object initialization for non-static methods
            StaticAndNonStaticMethods object = new StaticAndNonStaticMethods();
            object.showNumberPlus10(userNum);
            object.showNumberPlus100(userNum);
            
            //calling static method
            StaticAndNonStaticMethods.showNumberPlus1000(userNum);
        } 
        
        catch(Exception ex) {
            System.out.println("Invalid input.");
        }
        
    }
    
}
