package training.group6.Services;
import training.group6.Modeling.User;

public class BankServices {
    /**
     * Deposits money.
     *
     * @param user --user object.
     * @param amount --amount to deposit.
     */
    public static void deposit(User user, double amount) {
        user.setBalance(user.getBalance() + amount);
        System.out.println("Deposited $" + amount + " successfully.");
    }

    /**
     * Withdraws money, if available.
     *
     * @param user--user object.
     * @param amount--amount to withdraw.
     */
    public static void withdraw(User user, double amount) {
        if (user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            System.out.println("Withdrawn $" + amount + " successfully.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    /**
     * Checks balance.
     *
     * @param user--user object.
     * @return current balance.
     */
    public static double checkBalance(User user) {
        return user.getBalance();
    }
}
