package tests;

import org.junit.Test;
import pages.HomePage;

public class LogInTest extends BaseTest{

    @Test
    public void verifyUserCanBeLoggedIn (){
        new HomePage(driver)
                .clickLogInButton()
                .switchIntoLoginFrame()
                .clickLogIntoLoginField()
                .fillUsernameField("atqc_test")
                .fillPasswordField("atqc_test")
                .clickLogIn()
                .verifyUserLoggedIn();
   }

}
