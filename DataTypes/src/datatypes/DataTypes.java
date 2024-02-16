/***********************************************************************************************************************************
*   Author: Khyla Ehza Hondrade 
*   Activity Type: 03 Hands-on Activity 1
*
*   Program Name: DataTypes.java
*   Description: Initializing and printing variables
*   Date Created: 10/16/2020
***********************************************************************************************************************************/

package datatypes;

public class DataTypes {
	public static void main(String[] args) {
		
		//Initializing variables
		String firstName = "Khyla Ehza";
		String lastName = "Hondrade";
		char mi = 'R';
		int faveNumber = 3;
		String faveCartChar = "Katara of Avatar: The Last Airbender";

		//Printing variables
		System.out.println("My name is " + firstName + " " + mi + ". " + lastName + ".");
		System.out.println(faveNumber + " is my favorite number.");
		System.out.println("I love " + faveCartChar + "!");
	}
}