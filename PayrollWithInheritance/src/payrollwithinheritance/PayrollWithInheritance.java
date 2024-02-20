/*
 * Name: Khyla Ehza Hondrade
 * Activity: Task Performance 1
 * Description: A Simple Payroll Program that exhibits inheritance.
 * Date Submitted: 10/18/2021
 */
package payrollwithinheritance;
import java.util.Scanner;

public class PayrollWithInheritance {
    public static void main(String[] args) {
        
        String employeeName;
        char employmentType;
        double employeeSalary, employeeRatePerHour;
        int employeeHours, employeeRepeat;
        boolean willRepeat = true;
        
        // Initializing objects
        FullTimeEmployee fullEmpObj = new FullTimeEmployee();
        PartTimeEmployee partEmpObj = new PartTimeEmployee();
        
        // Repeats the program
        while (willRepeat) {
            Scanner employeeInput = new Scanner(System.in); 
            System.out.print("Enter your name: ");
            employeeName = employeeInput.nextLine();

            System.out.print("Press F for Full Time of P for Part Time: ");
            employmentType = employeeInput.next().charAt(0);
            employmentType = Character.toUpperCase(employmentType);

            // Use to call the appriopriate object and set the data.
            switch (employmentType) {            
                case 'F':                  
                    System.out.print("Enter monthly salary: ");
                    employeeSalary = employeeInput.nextDouble();
                    
                    fullEmpObj.setName(employeeName);
                    fullEmpObj.setMonthlySalary(employeeSalary);
                    break;
                    
                case 'P':
                    System.out.print("Enter rate per hour and no. of hours worked separated by space: ");
                    employeeRatePerHour = employeeInput.nextDouble();
                    employeeHours = employeeInput.nextInt();
                
                    partEmpObj.setName(employeeName);
                    partEmpObj.setWage(employeeHours, employeeRatePerHour);
                    break;
                    
                default:
                    System.out.println("Invalid input");
                    System.exit(0);
                    break;
            }
            
            // Uses ternary operator to access the appriopriate object and get the methods.
            System.out.printf("\nName: %s\n", ((employmentType == 'F') ? fullEmpObj.getName() : partEmpObj.getName()));
            System.out.printf("Wage/Salary: %.2f", ((employmentType == 'F') ? fullEmpObj.getMonthlySalary() : partEmpObj.getWage()));
            
            System.out.print("\n\nDo you want to repeat the program?\n[1]Yes\n[2]No\n");
            employeeRepeat = employeeInput.nextInt();
            willRepeat = (employeeRepeat == 1);
            System.out.println("--------------------------------------------------------------------");
        } 
    }   
}
// base class
class Employee {
    private String name = "Anonymous"; // the user input will override this
    
    public void setName(String empName) {
        this.name = empName;
    }
    
    public String getName() {
        return name;
    }
}

// derived class
class FullTimeEmployee extends Employee {
    private double monthlySalary;
    
    public void setMonthlySalary(double empSalary) {
        this.monthlySalary = empSalary;
    }
    
    public double getMonthlySalary() {
        return monthlySalary;
    }
}

// derived class
class PartTimeEmployee extends Employee{
    private double ratePerHour, wage;
    private int hoursWorked;
    
    public void setWage(int empHours, double empRate) {
        this.ratePerHour = empRate;
        this.hoursWorked = empHours;
        this.wage = ratePerHour * hoursWorked;
    }
    
    public double getWage() {
        return wage;
    }
}