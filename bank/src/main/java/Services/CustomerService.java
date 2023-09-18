package Services;
import Model.Customer;
//import Util.LogUtil;

import java.util.ArrayList;
import java.util.List;
public class CustomerService {
    /**List of bank customers to add onto
     *
     */
    List<Customer> BankCustomers;


    /**Instantiates the arraylist of customers
     *
     */
    public CustomerService(){
        BankCustomers = new ArrayList<>();
        //logutil
    }

    /**Overloading control
     *
     * @param x
     */
    public CustomerService(List<Customer> x){
        BankCustomers = x;

    }

    /**Add customer with a name and initial balance
     *
     * @param name
     * @param initial
     */
    public void addCustomer(String name, double initial){
        Customer x = new Customer(name, initial);
        BankCustomers.add(x);
    }

    /**Returns the list of customers
     *
     * @return
     */
    public List<Customer> getList() {

        return BankCustomers;
    }


    /**Given a customer name, finds customer Object, assuming no name duplicates, and
    processes fees**/

    public void feeCustomer(String name) {
        for(int i = 0; i < BankCustomers.size(); i++){
            Customer y = BankCustomers.get(i);
            if(y.getName().equals(name))
                y.processFee();

        }

    }


}
