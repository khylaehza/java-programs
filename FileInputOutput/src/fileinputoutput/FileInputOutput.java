/*
 * Name: Khyla Ehza Hondrade
 * Activity: 06 Task Performance 1 (FileInputOutput)
 * Description: A program that handles exception and allows IO to and from text file.
 * Date Submitted: 11/20/2021
 */
package FileInputOutput;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import static java.nio.file.StandardOpenOption.*;

// user-defined exception
class NotAlphaNumericException extends Exception {
    public NotAlphaNumericException() {
        super("Only alphanumeric characters are allowed.\n");
    }
}

public class FileInputOutput {

       // buffered writer
    public static void fileWriter(Path fileName, String userName, String userPass) {
        try {
            // note that I used TRUCATE_EXISTING instead of CREATE to replace the existing data of file 
            // everytime the user input new username and password. 
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(fileName, TRUNCATE_EXISTING));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            writer.write(userName, 0, userName.length());
            writer.newLine();
            writer.write(userPass, 0, userPass.length());
            writer.newLine();
            
            writer.close();
            
        } catch(IOException io) {
            io.printStackTrace();
        }   
    }
    
    // buffered reader
    public static void fileReader(Path fileName, String userName, String userPass) {
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName.toFile()));
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            
            if ((line1.equals(userName)) && line2.equals(userPass)) {
                    System.out.println("Successfully logged in.");
            } else {
                    System.out.println("Incorrect username or password.");
            }
            
        } catch (IOException io) {
            io.printStackTrace();
        }      
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // change the path file
        Path file = Paths.get("path\\records.txt");
        boolean willRepeat = true;
        System.out.println("WELCOME TO USER-LOG IN SYSTEM!");
      
        while(willRepeat) {
            System.out.println("Choose between registering or logging in.\n[1] Register\n[2] Login");
            int userChoice = input.nextInt();
                    
            try {
                switch (userChoice) {
                    case 1:
                        String newUsername, newPassword;
                        
                        System.out.println("\n---REGISTERING---");
                        System.out.print("Enter new username: ");
                        input.nextLine();
                        newUsername = input.nextLine();
                        
                        if(!newUsername.matches("^[a-zA-Z0-9]*$"))
                            throw new NotAlphaNumericException();
                        
                        System.out.print("Enter new password: ");
                        newPassword = input.nextLine();
                        
                        if(!newPassword.matches("^[a-zA-Z0-9]*$"))
                            throw new NotAlphaNumericException();
                        
                        fileWriter(file, newUsername, newPassword);
                        break;
                        
                    case 2:
                        String userLog, userPassLog;
                        
                        System.out.println("\n---LOGGING IN---");
                        System.out.print("Enter username: ");
                        input.nextLine();
                        userLog = input.nextLine();
                        System.out.print("Enter pass: ");
                        userPassLog = input.nextLine();
                        
                        fileReader(file, userLog, userPassLog);
                        break;
                        
                    default:
                        throw new InputMismatchException();
                }
                
                System.out.println("\nRepeat the program?\n[1]Yes\n[2]No");
                int userAns = input.nextInt();
                willRepeat = userAns == 1; 
            
            } catch(NotAlphaNumericException | InputMismatchException formatE) {
                System.out.println(formatE.getMessage());
            }
        }         
    }  
    
}
