/***********************************************************************************************************************************
 *  Author: Khyla Ehza Hondrade
 *  Activity Type: 04 Hands-on Activity 1
 *  
 *  Program Name: StaticComputation.java
 *  Description: A program that calculates and prints the monthly pay of an employee.
 *  Date Created: 10/30/2020
***********************************************************************************************************************************/

package staticcomputation;

public class StaticComputation {
	public static void main(String[] args) {
		
		//Holds the name of employee and amount of gross pay
		String employeeName = "Khyla Ehza Hondrade";
		double grossPay = 25000;
		
		//Holds the calculation of deductions
		double withholdingTax = grossPay * 0.15;
		double sssContribution = grossPay * 0.0363;
		double mediCare = grossPay * 0.0125;
		double pagIbig = 100;
		//Calculating Net Pay
		double netPay = grossPay - (withholdingTax + sssContribution + mediCare + pagIbig);
		
		//Printing the information
		System.out.println("Employee Name:             " + employeeName);
		System.out.println("Gross Pay:                 " + grossPay);
		System.out.println("_______________________________________");
		System.out.println("Deductions                 Amount");
		System.out.println("Withholding Tax:           " + withholdingTax);
		System.out.println("SSS Contribution:          " + sssContribution);
		System.out.println("Medicare:                  " + mediCare);
		System.out.println("Pagibig Contribution:      " + pagIbig);
		System.out.println("_______________________________________");
		System.out.println("Net Pay:                   " + netPay);
	}
}