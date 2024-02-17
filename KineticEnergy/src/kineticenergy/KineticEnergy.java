/***********************************************************************************************************************************
*  Author: Khyla Ehza Hondrade
*  Activity Type: 12 eLMS Activity 1 - ARG	
*  
*  Program Name: Recursion Vowels
*  Description: Write a recursive method that will return the number of vowels in a given string.
*  Date Created: 1/21/2021
***********************************************************************************************************************************/

package kineticenergy;
import java.util.Scanner;
import java.lang.Math;
public class KineticEnergy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter mass in kilograms: " );
		int kilograms = scanner.nextInt();
		System.out.print("Enter velocity in meters per second: ");
		double velocity = scanner.nextDouble();
		
		// Assigning the KineticComputation function to variable answer
		double answer = KineticComputation(kilograms, velocity); 
			
		//Outputs	
		System.out.println("The object's kinetic energy is: " + answer + " J.");
	}
	
	//KineticComputation function
	public static double KineticComputation(int _kilograms, double _velocity) {	
		double answer = ((double)1/2) * (_kilograms * Math.pow(_velocity, 2)); //Computation of Kinetic Energy
		return Math.round(answer * 100.0)/100.0; //Using of Math Class to round the answer into two decimal places.
	}
}