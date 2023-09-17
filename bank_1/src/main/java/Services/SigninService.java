package Services;
import Util.LogUtil;

public class SigninService {
    BankerService bankerService;
    CustomerService customerService;

    /** Setting up logutil
     *
     */
    public SigninService(){
        LogUtil.log.info("Setting up sign in service");
    }

    /**overloading constructor
     *
     * @param b
     * @param c
     */
    public SigninService(BankerService b, CustomerService c){
        this.bankerService = b;
        this.customerService = c;
    }

    /** Checks for correct login
     *
     * @param username
     * @param password
     * @return
     */
    public static boolean checkBankerSignin(String username, String password) {
        if(username.equals("username123")&&(password.equals("password123")))
            return true;
        else return false;

    }
}
