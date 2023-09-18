import Model.Customer;
import Services.SigninService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignInServiceTest {
    SigninService sign;

    public void setUp(){
        sign = new SigninService();
    }

    public void ValidSignin(){

        boolean expected = true;
        boolean actual = SigninService.checkBankerSignin("username123", "password123");
        Assert.assertEquals(expected, actual);

    }
}
