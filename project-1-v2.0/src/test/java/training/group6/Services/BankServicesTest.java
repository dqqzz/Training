package training.group6.Services;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import training.group6.Modeling.User;

public class BankServicesTest extends TestCase {
User user=new User("john","200");
    /**
    * testing deposit() method in Service layer
    */
    @Test
    public void testDeposit() {
        BankServices.deposit(user,100);
        double expected=user.getBalance();
        double actual=100.;
        Assert.assertEquals(expected, actual);
    }
     /**
    * testing withdraw() method in Service layer
    */
    @Test
    public void testWithdraw() {
        BankServices.deposit(user,500);
        BankServices.withdraw(user,100);
        double expected=user.getBalance();
        double actual=400.;
        Assert.assertEquals(expected, actual);
    }

}