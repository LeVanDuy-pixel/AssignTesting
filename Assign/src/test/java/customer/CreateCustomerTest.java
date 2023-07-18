package customer;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;
public class CreateCustomerTest extends BaseTests {
    private Random ran = new Random();
    @Test
    @DisplayName("TC01-Verify User is able to create new customer when input an email that not registered")
    public void testCreateSuccessful(){
        loginpage.Login();
        managePage.clickNewCustomerArea();
        customerPage.setCusName("abx");
        customerPage.setGender("female");
        customerPage.setDob("03/02/2002");
        customerPage.setAddress("Khu tao song");
        customerPage.setCity("DN city");
        customerPage.setState("DN state");
        customerPage.setPin("500000");
        customerPage.setPhone("012345");
        customerPage.setEmail("linhlhde"+ran.nextInt(999999)+"@fpt.edu.vn");
        customerPage.setPassword("123");
        customerPage.clickSubmitButton();
        String createCustomerMsg = managePage.getCreateCustomerMessage();
        Assertions.assertTrue(createCustomerMsg.contains("Customer Registered Successfully!!!"),"create customer is failed!");
    }
    @Test
    @DisplayName("TC02-Verify User is not able to create new customer when input an email that registered")
    public void testWithRegisteredEmail(){
        loginpage.Login();
        managePage.clickNewCustomerArea();
        customerPage.setCusName("abx");
        customerPage.setGender("female");
        customerPage.setDob("03/02/2002");
        customerPage.setAddress("Khu tao song");
        customerPage.setCity("DN city");
        customerPage.setState("DN state");
        customerPage.setPin("500000");
        customerPage.setPhone("012345");
        customerPage.setEmail("linhlhde160357@fpt.edu.vn");
        customerPage.setPassword("123");
        customerPage.clickSubmitButton();
        String alertText = managePage.getAlertText();
        managePage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("Email Address Already Exist !!"),"Alert text is incorrect!");
    }
    @Test
    @DisplayName("TC03-Verify User is not able to create new customer without login")
    public void testCreateWithoutLogin(){
        driver.get("https://www.demo.guru99.com/V4/manager/Managerhomepage.php");
        managePage.clickNewCustomerArea();
        customerPage.setCusName("abx");
        customerPage.setGender("female");
        customerPage.setDob("03/02/2002");
        customerPage.setAddress("Khu tao song");
        customerPage.setCity("DN city");
        customerPage.setState("DN state");
        customerPage.setPin("500000");
        customerPage.setPhone("012345");
        customerPage.setEmail("linhlhde"+ran.nextInt(999999)+"@fpt.edu.vn");
        customerPage.setPassword("123");
        customerPage.clickSubmitButton();
        String alertText = managePage.getAlertText();
        managePage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("Your User id is wrong please provide correct userid"),"create customer is failed!");
    }
    @Test
    @DisplayName("TC04-Verify customer form is clear when click reset button")
    public void testClearCustomerForm(){
        loginpage.Login();
        managePage.clickNewCustomerArea();
        customerPage.setCusName("abx");
        customerPage.setGender("female");
        customerPage.setDob("03/02/2002");
        customerPage.setAddress("Khu tao song");
        customerPage.setCity("DN city");
        customerPage.setState("DN state");
        customerPage.setPin("500000");
        customerPage.setPhone("012345");
        customerPage.setEmail("linhlhde"+ran.nextInt(999999)+"@fpt.edu.vn");
        customerPage.setPassword("123");
        customerPage.clickResetButton();
        Assertions.assertTrue(customerPage.isClearForm(),"Form is not empty");
    }
    @Test
    @DisplayName("TC05-Verify User is not able to create new customer when input with unicode")
    public void testCreateWithInputUnicode(){
        loginpage.Login();
        managePage.clickNewCustomerArea();
        customerPage.setCusName("abx");
        customerPage.setGender("female");
        customerPage.setDob("03/02/2002");
        customerPage.setAddress("Khu tao song");
        customerPage.setCity("DN city");
        customerPage.setState("Việt Nam");
        customerPage.setPin("500000");
        customerPage.setPhone("012345");
        customerPage.setEmail("linhlhde"+ran.nextInt(999999)+"@fpt.edu.vn");
        customerPage.setPassword("123");
        customerPage.clickSubmitButton();
        String alertText = managePage.getAlertText();
        managePage.acceptJSAlert();
        Assertions.assertTrue(alertText.contains("please fill all fields"),"Alert text is incorrect!");
    }
}
