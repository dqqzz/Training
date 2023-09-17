package Util;

import Model.Customer;
import Services.CustomerService;
import Services.BankerService;
import Services.SigninService;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

//General Main Application
public class Application {
    public static void main(String[] args) {
        CustomerService cs = new CustomerService();
        BankerService bs = new BankerService();
        cs.addCustomer("Jason", 1000);
        cs.addCustomer("David", 2000);
/** Asks users banker or customer, verifies username and password
 * Then checks to find the customer object to the name requested.
 * Allows banker to process fees, view account balance, or apply interest to
 * the customer object
 */

        while(true){
            System.out.println("Banker or Customer?");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if(input.equals("Banker")){
                System.out.println("Enter Username: ");
                String username = scan.nextLine();
                System.out.println("Enter Password: ");
                String password = scan.nextLine();
                boolean result = SigninService.checkBankerSignin(username, password);
                if(result){
                    System.out.println("A) Process Fees");
                    System.out.println("B) Apply Interest");
                    System.out.println("C) View Account");
                    String x = scan.nextLine();
                    if(x.equals("A")){
                        System.out.println("Enter name of Customer");
                        String name = scan.nextLine();
                        //Customer cust = cs.findCustomer(name);
                        // System.out.println(cs.getBalance(cust));

                    }
                }

            }
        }

    }

}
