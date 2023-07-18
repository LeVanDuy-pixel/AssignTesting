package account;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateAccountTests extends BaseTests {
    @Test
    @DisplayName("TC01-Verify User is able to create new account when input existed Customer id, Account type is Savings and Initial deposit is equal or more than 500")
    public void testCreateSuccessful(){
        loginpage.Login();
        managePage.clickNewAccountArea();
        accountPage.setCusId("11619");
        accountPage.setAccType("Savings");
        accountPage.setInitDeposit("501");
        accountPage.clickSubmitButton();
        String createAccountMsg = managePage.getCreateAccountMessage();
        Assertions.assertTrue(createAccountMsg.contains("Account Generated Successfully!!!"),"create account message is incorrect!");
    }
    @Test
    @DisplayName("TC02-Verify User is not able to create new account when not input Customer id")
    public void testWithNoInputCusID(){
        loginpage.Login();
        managePage.clickNewAccountArea();
        accountPage.setAccType("Savings");
        accountPage.setInitDeposit("501");
        accountPage.clickSubmitButton();
        String alertText = managePage.getAlertText();
        managePage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("Please fill all fields"),"Alert text is incorrect!");
    }
    @Test
    @DisplayName("TC03-Verify User is not able to create new account when not input Initial deposit")
    public void testWithNoInputDeposit(){
        loginpage.Login();
        managePage.clickNewAccountArea();
        accountPage.setCusId("11619");
        accountPage.setAccType("Savings");
        accountPage.clickSubmitButton();
        String alertText = managePage.getAlertText();
        managePage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("Please fill all fields"),"Alert text is incorrect!");
    }
    @Test
    @DisplayName("TC04-Verify User is not able to create new account when input no existed Customer id")
    public void testWithNoExistedCusID(){
        loginpage.Login();
        managePage.clickNewAccountArea();
        accountPage.setCusId("12345678");
        accountPage.setAccType("Savings");
        accountPage.setInitDeposit("501");
        accountPage.clickSubmitButton();
        String alertText = managePage.getAlertText();
        managePage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("Customer does not exist!!"),"Alert text is incorrect!");
    }
    @Test
    @DisplayName("TC05-Verify User is not able to create new account when input special character in Customer id field")
    public void testWithSpecialCharactersCusID(){
        loginpage.Login();
        managePage.clickNewAccountArea();
        accountPage.setCusId("11619@");
        accountPage.setAccType("Savings");
        accountPage.setInitDeposit("501");
        accountPage.clickSubmitButton();
        String alertText = managePage.getAlertText();
        managePage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("Please fill all fields"),"Alert text is incorrect!");
    }
    @Test
    @DisplayName("TC06-Verify User is not able to create new account when input value under 500 in Initial deposit field")
    public void testWithDepositUnder500(){
        loginpage.Login();
        managePage.clickNewAccountArea();
        accountPage.setCusId("11619");
        accountPage.setAccType("Savings");
        accountPage.setInitDeposit("409");
        accountPage.clickSubmitButton();
        String alertText = managePage.getAlertText();
        managePage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("Intial deposite must be Rs. 500 or more"),"Alert text is incorrect!");
    }
    @Test
    @DisplayName("TC07-Verify User's input is reset when press reset button")
    public void testCusIDisClear(){
        loginpage.Login();
        managePage.clickNewAccountArea();
        accountPage.setCusId("11619");
        accountPage.setAccType("Current");
        accountPage.setInitDeposit("409");
        accountPage.clickResetButton();
        String cusIdVal = accountPage.getCusId();
        Assertions.assertTrue(cusIdVal.isEmpty(),"Customer ID is not reset");
    }
}
