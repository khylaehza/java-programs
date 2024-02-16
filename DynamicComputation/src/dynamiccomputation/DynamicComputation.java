/***********************************************************************************************************************************
 *  Author: Khyla Ehza Hondrade
 *  Activity Type: 06 Task Performance 1
 *  
 *  Program Name: DynamicComputation.java
 *  Description: A program that computes and displays a game character's attack speed at a certain level.
 *  Date Created: 11/5/2020
***********************************************************************************************************************************/
//Importing Scanner Class
package dynamiccomputation;
import java.util.Scanner;

public class DynamicComputation {
	public static void main(String[] args) {
	
		//Creating scanner object
		Scanner scannerInput = new Scanner(System.in);
		
		//Declaring variables
		int characterLevel;
		double currentAttackSpeed, baseAttackSpeed, bonusAttackSpeed;
		
		//Ask for scanner input data and assign to their variables
		System.out.print("Enter the base attack speed: ");
		baseAttackSpeed = scannerInput.nextDouble();
		System.out.print("\nEnter the bonus attack speed %: ");
		bonusAttackSpeed = scannerInput.nextDouble();
		System.out.print("\nEnter the level: ");
		characterLevel = scannerInput.nextInt();
		
		//Calculates the current attack speed
	    currentAttackSpeed = baseAttackSpeed * (1 + ((bonusAttackSpeed / 100)*(characterLevel - 1)));
	    //Uses printf to output and format the floating point number with 3 decimal point
		System.out.printf("\nThe character's current attack speed is %.3f.", currentAttackSpeed);
	}
}