/***********************************************************************************************************************************
 *  Author: Khyla Ehza Hondrade
 *  Activity Type: 09 Task Performance 1
 *  
 *  Program Name: ThreeNames.java
 *  Description: A program that asks the user to enter three (3) first names and uses string methods.
 *  Date Created: 12/10/2020
***********************************************************************************************************************************/

package threenames;

import java.util.Scanner;
public class ThreeNames {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String name1, name2, name3, possible1, possible2, possible3, possible4, possible5, possible6;
		
		//Asking for the names
		System.out.println("Enter three first names: ");
		name1 = input.next();
		name2 = input.next();
		name3 = input.next();
		
		//Joining the names
		possible1 = name1.concat(" ").concat(name2);
		possible2 = name1.concat(" ").concat(name3);
		possible3 = name2.concat(" ").concat(name1);
		possible4 = name2.concat(" ").concat(name3);
		possible5 = name3.concat(" ").concat(name1);
		possible6 = name3.concat(" ").concat(name2);
		
		//Outputs all possible names
		System.out.println("Possible names are: ");
		System.out.println("1 - " + possible1);
		System.out.println("2 - " + possible2);
		System.out.println("3 - " + possible3);
		System.out.println("4 - " + possible4);
		System.out.println("5 - " + possible5);
		System.out.println("6 - " + possible6);
			
		//Asking for the number of possible names
		System.out.print("Enter 1-6 to select a name: ");
		int number = input.nextInt();
		
		//Using switch statement to checks the case number and display necessary outputs through methods of .charAt(index), .toLowerCase(), and .replace('', '').
		switch(number) {
			case 1: 
				System.out.println("The initials for " + possible1 + " is " + name1.charAt(0) + name2.charAt(0) + ".");
				System.out.println("Suggested username: " + possible1.toLowerCase().replace(' ', '_'));
				break;
			case 2:
				System.out.println("The initials for " + possible2 + " is " + name1.charAt(0) + name3.charAt(0) + ".");
				System.out.println("Suggested username: " + possible2.toLowerCase().replace(' ', '_'));
				break;
			case 3:
				System.out.println("The initials for " + possible3 + " is " + name2.charAt(0) + name1.charAt(0) + ".");
				System.out.println("Suggested username: " + possible3.toLowerCase().replace(' ', '_'));
				break;
			case 4:
				System.out.println("The initials for " + possible4 + " is " + name2.charAt(0) + name3.charAt(0) + ".");
				System.out.println("Suggested username: " + possible4.toLowerCase().replace(' ', '_'));
				break;
			case 5:
				System.out.println("The initials for " + possible5 + " is " + name3.charAt(0) + name1.charAt(0) + ".");
				System.out.println("Suggested username: " + possible5.toLowerCase().replace(' ', '_'));
				break;
			case 6:
				System.out.println("The initials for " + possible6 + " is " + name3.charAt(0) + name2.charAt(0) + ".");
				System.out.println("Suggested username: " + possible6.toLowerCase().replace(' ', '_'));
				break;
		}
	}
}