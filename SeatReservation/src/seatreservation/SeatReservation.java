/***********************************************************************************************************************************
*  Author: Khyla Ehza Hondrade
*  Activity Type: 10 Hands-on Activity 1 - ARG	
*  
*  Program Name: SeatReservation
*  Description: Create arrays in a program; Access array elements; Perform array operations; and use the Array class.
*  Date Created: 1/16/2021
***********************************************************************************************************************************/

package seatreservation;
import java.util.*;

public class SeatReservation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[][] reserveSeat = new char[10][4]; //Declare 10 elements in row and 4 elements in column
		int userRow, userCol; // variable of user's input for row and col
		
		// Use of Array Fill class to assign the *
		for(char[] row: reserveSeat) {
				Arrays.fill(row, '*');	
		}
		
		do {
			System.out.println("Bus Seat Reservation: ");
			
			//Outputs the Column Label Number
			for(int colLabel = 1; colLabel <= 4; colLabel++) {
				System.out.print("\t\tCol " + colLabel);
			} System.out.println();
			
			//Prints the Bus Seat Reservation Table
			for(int row = 0; row < reserveSeat.length; row++) {
				System.out.printf("Row %d\t|", row + 1); // Outputs the Row Label Number
				for(int col = 0; col < reserveSeat[row].length; col++) {	
					System.out.print(reserveSeat[row][col] + "\t\t\t"); //Outputs the '*' or 'X'
				} System.out.println();
			} 
			
			System.out.print("Enter row and column number to reserve separated by space (Enter negative number to exit): ");
			userRow = scanner.nextInt();
		
			if(userRow < 0) {
				System.out.println("Program Exit!");
				break; // breaks the loop if the inputted number is negative.
			}
			 
			userCol = scanner.nextInt();
			
			// Use of for loop to assign the 'X'
		/*	for(int row = 0; row < reserveSeat.length; row++) {
				for(int col = 0; col < reserveSeat[row].length; col++) {
					reserveSeat[userRow - 1][userCol - 1] = 'X';
				}
			}System.out.println();		*/
		
			if(userRow > 0) {
				reserveSeat[userRow - 1][userCol - 1] = 'X';
			}	
				
		}while(true); // Loops the code until the user input negative number.	
   }																																				
}