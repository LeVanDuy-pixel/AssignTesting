package logout;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LogoutTests extends BaseTests {

    @Test
    @DisplayName("TC07-Logout successfully")
    public void testLogoutSuccess(){
        loginpage.Login();
        managePage.clickLogoutArea();
        String successAlert = managePage.getAlertText();
        managePage.acceptJSAlert();

        Assertions.assertTrue(successAlert.contains("You Have Succesfully Logged Out!!"),"Success text is incorrect!");
    }
}
