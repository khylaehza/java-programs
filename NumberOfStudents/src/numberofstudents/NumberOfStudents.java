/***********************************************************************************************************************************
 *  Author: Khyla Ehza Hondrade
 *  Activity Type: Midterm Practical Exam - ARG
 *  
 *  Program Name: NumberOfStudents.java
 *  Description: A a program that asks the user for the number of male and female students registered in a class/section, and 
 *               calculates the number of whole students registered in classroom, with percentage of males and females.
 *  Date Created: 11/9/2020
***********************************************************************************************************************************/

package numberofstudents;
import java.util.Scanner;

public class NumberOfStudents {
	public static void main(String[] args) {
		//Creating the scanner object and declaring variables
		Scanner inputScanner = new Scanner(System.in);
		int numberOfMales, numberOfFemales, numberOfStudents;
		double malePercentage, femalePercentage;
		
		//Asking for number of male and females
		System.out.print("Enter the number of males: ");
		numberOfMales = inputScanner.nextInt();
		System.out.print("Enter the number of females: ");
		numberOfFemales = inputScanner.nextInt();
		
		//Computing the overall number of students and converting the number of male and female to percentage.
		//Notice that I used type casting to prevent logical error
		numberOfStudents = numberOfMales + numberOfFemales;
		malePercentage = (numberOfMales / (double) numberOfStudents) * 100;
		femalePercentage = (numberOfFemales / (double) numberOfStudents) * 100;
		
		//Displaying the information
		System.out.println("Number of students: " + numberOfStudents);
		System.out.printf("Male = %.2f%%", malePercentage);
		System.out.printf("\nFemale = %.2f%%", femalePercentage);		
	}
}