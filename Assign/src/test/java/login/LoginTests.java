package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginTests extends BaseTests {
    @Test
    @DisplayName("TC01-Login successfully")
    public void testLoginSuccessful(){
        loginpage.setUserName("mngr512467");
        loginpage.setPassword("sejEtug");
        loginpage.clickLoginButton();
        String welcomeText = managePage.getWelcomeText();
        Assertions.assertTrue(welcomeText.contains("Welcome To Manager's Page of Guru99 Bank"),"Welcome text is incorrect!");
    }
    @Test
    @DisplayName("TC02-Login fail with invalid info")
    public void testLoginFail(){
        loginpage.setUserName("mnnn123456");
        loginpage.setPassword("abc123");
        loginpage.clickLoginButton();
        String alertText = loginpage.getAlertText();
        loginpage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("User or Password is not valid"),"Alert text is incorrect!");
    }
    @Test
    @DisplayName("TC03-Login fail with uppercase UserId")
    public void testWithUpperUID(){
        loginpage.setUserName("MNGR512467");
        loginpage.setPassword("sejEtug");
        loginpage.clickLoginButton();
        String alertText = loginpage.getAlertText();
        loginpage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("User or Password is not valid"),"Alert text is incorrect!");
    }
    @Test
    @DisplayName("TC04-Login fail with all uppercase Password")
    public void testWithUpperPass(){
        loginpage.setUserName("mngr512467");
        loginpage.setPassword("SEJETUG");
        loginpage.clickLoginButton();
        String alertText = loginpage.getAlertText();
        loginpage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("User or Password is not valid"),"Alert text is incorrect!");
    }
    @Test
    @DisplayName("TC05-Login successful with other valid account")
    public void testOtherValidAccount(){
        loginpage.setUserName("mngr512476");
        loginpage.setPassword("dAdebEd");
        loginpage.clickLoginButton();
        String welcomeText = managePage.getWelcomeText();
        Assertions.assertTrue(welcomeText.contains("Welcome To Manager's Page of Guru99 Bank"),"Welcome text is incorrect!");
    }
    @Test
    @DisplayName("TC06-Login fail when leave blank UserId or Password")
    public void testFailWhenBlank(){
        loginpage.setUserName("mngr512467");
        loginpage.clickLoginButton();
        String alertText = loginpage.getAlertText();
        loginpage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("User or Password is not valid"),"Alert text is incorrect!");
    }
}
