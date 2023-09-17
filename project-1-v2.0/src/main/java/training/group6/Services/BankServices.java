package training.group6.Services;
import training.group6.Modeling.User;

public class BankServices {
    // Method to deposit money
    public static void deposit(User user, double amount) {
        user.setBalance(user.getBalance() + amount);
        System.out.println("Deposited $" + amount + " successfully.");
    }

    // Method to withdraw money
    public static void withdraw(User user, double amount) {
        if (user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            System.out.println("Withdrawn $" + amount + " successfully.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Method to check balance (inquiry)
    public static double checkBalance(User user) {
        return user.getBalance();
    }
}
