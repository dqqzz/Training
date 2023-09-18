package training.group6;
import java.util.Scanner;
import training.group6.Modeling.User;
import training.group6.Services.BankServices;
import java.util.ArrayList;

/**
 * This is the main class for the application.
 */
public class App {
    /**
     * The entry point .
     *
     * @param args --not for this application 
     * @param user the object of class User from Modeling layer
     * @param userList The List to store all User objects
     */
    public static void main(String[] args) {

        ArrayList<User> userList = new ArrayList<>();
	
	/**
 	*This loop simulates user banking behaviors
 	*/
        while (true) {
	    /**
 	    *@param scanner read user input
	    *@param username User object property
	    *param password User object property
 	    */
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username: ");
            String username = scanner.nextLine();

            System.out.println("Enter password: ");
            String password = scanner.nextLine();

            boolean found = false; //@param found indicate whether the user exists?
            User currentUser = null; //@param currentUser initial current user as null
	    /**
 	    *This loop is used for login when a user exists
	    *equals() The built-in Java method to determine if strings are equal
 	    */
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUsername().equals(username) && userList.get(i).getPassword().equals(password)) {
                    found = true;
                    System.out.println("Login successful!");
                    currentUser = userList.get(i); // Set the current user
                    break; // Exit the loop
                }
            }
	     /**
 	    *this block for register if user is not existed,and add to Collection
	    */
            if (!found) {
                // user is not existed, perform registration
                currentUser = new User(username, password);
                userList.add(currentUser); // Add the new user to the List
                System.out.println("Register successful!");
            }

            // Options for banking
            System.out.println("Choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
	    /**
 	    *@deposit() The static method invoked from class BankServices in Service layer
	    *@withdraw() The static method invoked from class BankServices in Service layer
	    *@checkBalance() The static method invoked from class BankServices in Service layer
 	    */
            switch (choice) {
                case 1:
                    System.out.println("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    BankServices.deposit(currentUser, depositAmount); // deposit
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    BankServices.withdraw(currentUser, withdrawalAmount); // withdrawal
                    break;
                case 3:
                    double balance = BankServices.checkBalance(currentUser); // Get balance
                    System.out.println("Balance: $" + currentUser.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting application.");
                    scanner.close();
                    System.exit(0); // Exit the application
                default:
                    System.out.println("Invalid option.");

            }
            //System.out.println(currentUser.getBalance());
	    // Print the size of the List
            System.out.println("The total number of registered users at the bank is: " + userList.size()); 
        }
    }
}
