/*
 * Name: Khyla Ehza Hondrade
 * Activity: 02 Hands-on Activity 1
 * Description: A program based on UML Class Diagram. Note: I followed the identifier names based on the instruction.
 * Date Submitted: 9/30/2021
 */

package umlclass;
import java.util.*;

public class UMLClass {

   String itemName;
    double itemPrice;
    int itemQuantity;
    double amountDue;
        
    public void setItemName(String newItemName) {
        this.itemName = newItemName;
    }
    
    public void setTotalCost(int quantity, double price) {
        this.itemQuantity = quantity;
        this.itemPrice = price;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public double getTotalCost() {
        return amountDue = itemQuantity * itemPrice;
    }
    
    public void readInput() {
        Scanner s = new Scanner(System.in);   
        System.out.println("Enter the name of the item you are purchasing: ");
        itemName = s.nextLine();
        System.out.println("Enter the quantity and price separated by a space: ");
        itemQuantity = s.nextInt();
        itemPrice = s.nextDouble();
        
        setItemName(itemName);
        setTotalCost(itemQuantity, itemPrice);
    }
    

    public void writeOutput() {
        System.out.printf("You are purchasing %d %s(s) at ₱%.1f each.\n", itemQuantity, itemName, itemPrice);
        System.out.printf("Amount due is ₱%.2f.\n", getTotalCost());
    }
    
    public static void main(String[] args) {
            // I initialized object since I didn't use static methods.
            UMLClass object = new UMLClass();
            object.readInput();
            object.writeOutput();
    } 
    
}
