package Model;

public class Customer {
    double balance;
    String name;

    public Customer(String name, double initial){
        this.name = name;
        this.balance = initial;
    }

    public String getName() {
        return name;
    }

    public double getBalance(Customer x){
        return x.balance;
    }

    public void processFee() {
        this.balance -= 40;

    }
}
