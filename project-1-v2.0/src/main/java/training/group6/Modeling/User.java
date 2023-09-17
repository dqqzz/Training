package training.group6.Modeling;

    /**
    * User class,user data model
    */
    public class User {
    private String username;
    private String password;
    private double balance;

    // Constructor with two parameters
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters (optional)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
