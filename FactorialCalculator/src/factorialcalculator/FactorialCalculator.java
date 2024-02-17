/***********************************************************************************************************************************
*  Author: Khyla Ehza Hondrade
*  Activity Type: 08 Hands-on Activity 1
*  
*  Program Name: FactorialCalculator
*  Description: Program that executes statements repeatedly, with nested loops, and break and continue statements.
*  Date Created: 12/2/2020
***********************************************************************************************************************************/

package factorialcalculator;

import java.util.Scanner;
public class FactorialCalculator{
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int inputNumber, repeatAsk = 1;
		
		System.out.println("<------Factorial Calculator------>");
		do {
			System.out.print("Enter a positive integer: "); //Step 1: Ask the user to enter positive number
			inputNumber = input.nextInt();
			int factorialNumber = 1;
			
			if(inputNumber >= 0 ) { //Step 2: Check if the number is positive 
				System.out.printf("%d! = ", inputNumber); 
				for(int loopStartNum = 1; loopStartNum <= inputNumber; loopStartNum++) { 
					factorialNumber *= loopStartNum; //Step 3: Calculates the factorial number
					
					//Example output: 5 x 4 x 3 x 2 x 1
					if(loopStartNum != inputNumber) {
						System.out.printf("%d x ", loopStartNum);
						continue; // To continue the loop					
					}
					else {
						System.out.printf("%d", loopStartNum);
					} 
				}
				System.out.printf("\nThe factorial of %d is: %d\n", inputNumber, factorialNumber);	//Outputs the factorial form		
			}
			
			else{ //Step 2: Display an error message if the number is negative
				System.out.println("Invalid input! Program stopped!");
				break; //To end the program.
			}
			
			repeatAsk++; //Increments until it reach 5 repeats
		}while(repeatAsk <= 5); //Step 4: Repeat step 1 to 3 for five times.
	}
}