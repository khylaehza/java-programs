/***********************************************************************************************************************************
*  Author: Khyla Ehza Hondrade
*  Activity Type: 07 Hands-on Activity 1
*  
*  Program Name: GrossPayCalculator
*  Description: Implement decision using one-way, two-way, multiple selections, and combine conditions using logical operators.
*  Date Created: 12/2/2020
***********************************************************************************************************************************/

package grosspaycalculator;
import java.util.Scanner; 
public class GrossPayCalculator {
	public static void main(String[] args) {
		
		Scanner inputScanner = new Scanner(System.in); 
		System.out.print("Enter employee name: "); //Ask the name of the employee
		String employeeName = inputScanner.nextLine();
		
		System.out.print("Press F for Full Time or P for Part Time: "); //Prompt the user to select between full time (F) and part time (P)
		char jobType = inputScanner.next().charAt(0);
		
		if(jobType == 'F') { //This will execute if the user press F
			double basicPay, grossPay;
			
			System.out.println("--- Full Time Employee ---");
			System.out.print("Enter Basic Pay: "); //Ask for monthly salary
			basicPay = inputScanner.nextDouble();
			
			System.out.println("___________________________________"); //Display name and salary information
			System.out.printf("Employee Name: %s\n", employeeName);
			System.out.printf("Basic Pay: %.1f     \n", basicPay);
			System.out.println("___________________________________");
			
			grossPay = basicPay; //Basic pay is the same with gross pay since it is a full time job
			System.out.printf("Gross Pay: %.1f", grossPay);
		}
		
		else if(jobType == 'P') { //This will execute if the user choose press P
			double ratePerHour, basicPay, overtimePay, grossPay;
			int hoursWorked, overTime;
			
			System.out.println("--- Part Time Employee ---");
			System.out.print("Enter rate per hour: "); //Ask for rate per hour
			ratePerHour = inputScanner.nextDouble();
			System.out.print("Enter no. of hours worked: "); // Ask for number of hours the employee worked
			hoursWorked = inputScanner.nextInt();
			System.out.print("Enter no. of overtime: "); // Ask for number of overtime
			overTime = inputScanner.nextInt();
			
			//Wage calculations
			basicPay = ratePerHour * hoursWorked; 
			overtimePay = overTime * (ratePerHour * ((double)125/100));
			grossPay = basicPay + overtimePay;
			
			System.out.println("___________________________________"); //Display name and wage information
			System.out.printf("Employee Name: %s\n", employeeName);
			System.out.printf("Basic Pay: %.1f\n", basicPay);
			System.out.printf("Overtime Pay: %.2f\n", overtimePay);
			System.out.println("___________________________________");
			System.out.printf("Gross Pay: %.2f", grossPay);
		}
		
		else {
			System.out.println("Sorry! Invalid input.");
		}
	}
}