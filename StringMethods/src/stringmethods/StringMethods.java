/*
 * Name: Khyla Ehza Hondrade
 * Activity: 01 Hands-on Activity 1
 * Description: A simple program composing inputs and outputs.
 * Additions: Uses substring(), toUpperCase(), split(), length(), String.valueof()
 * Date Submitted: 9/30/2021
 */
package stringmethods;
import java.util.Scanner;
public class StringMethods {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int faveNumber, nickNameLength;
        String faveCartChar, name, partOfNames = ""; // Instead of 'char mi', I use the String name
        char[] nickNameArray;

        // This is where the user inputs the information
        System.out.println("--- INPUT ---");
        System.out.print("Enter your favorite number: ");
        faveNumber = input.nextInt();
        input.nextLine();
        
        System.out.print("Enter your favorite anime character: ");
        faveCartChar = input.nextLine();
        // substring() and toUpperCase() are used to turn user's input first letter to upper case.
        faveCartChar = faveCartChar.substring(0,1).toUpperCase() + faveCartChar.substring(1, faveCartChar.length());
        
        System.out.print("Enter your name: ");
        name = input.nextLine();
        // split() is used to split name parts and capitalize every first letter
        for (String partOfName : name.split(" ")) {
            partOfNames += partOfName.substring(0,1).toUpperCase() + partOfName.substring(1, partOfName.length()) + " ";
        }
        name = partOfNames.substring(0, partOfNames.length()-1);
        
        System.out.print("Enter the number of letters in your nickname: ");
        nickNameLength = input.nextInt();
        nickNameArray = new char[nickNameLength];
        // asks for each characters of nickname
        for (int letter = 0; letter < nickNameArray.length; letter++) {
            System.out.printf("Enter nickname letter %d: ", letter + 1);
            nickNameArray[letter] = input.next().charAt(0);    
            if (letter == 0) {
                nickNameArray[letter] = Character.toUpperCase(nickNameArray[letter]);
            }
        }      

        // This is where the information will be display, uses printf
        System.out.println("\n--- OUTPUT ---");
        System.out.printf("%d is my favorite number.\n", faveNumber);
        System.out.printf("I love %s!\n", faveCartChar);
        System.out.printf("My name is %s.\n", name);
        // String.valueof() is used to convert the array of chars to string
        System.out.printf("You can call me %s.\n", String.valueOf(nickNameArray)); 
    }
    
}
