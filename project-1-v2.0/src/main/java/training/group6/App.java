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
     * @param args --not for this application .
     */
    public static void main(String[] args) {

        ArrayList<User> userList = new ArrayList<>();
	
	/**
 	*This loop simulates user banking behaviors
 	*/
        while (true) {
		/**
 		*read user input
 		*/
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username: ");
            String username = scanner.nextLine();

            System.out.println("Enter password: ");
            String password = scanner.nextLine();

            boolean found = false; //user existed?
            User currentUser = null; // initial current user
	    /**
 	    *this loop for login if user existed
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
                userList.add(currentUser); // Add the new user to the Collection
                System.out.println("Register successful!");
            }

            // Options for banking
            System.out.println("Choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
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
            System.out.println(currentUser.getBalance());
            System.out.println(userList.size()); // Print the size of the Collection
        }
    }
}
