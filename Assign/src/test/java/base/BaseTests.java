package base;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ManagePage;
import pages.NewAccountPage;
import pages.NewCustomerPage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    protected WebDriver driver;
    protected LoginPage loginpage;
    protected ManagePage managePage;
    protected NewAccountPage accountPage;
    protected NewCustomerPage customerPage;
    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
        loginpage = new LoginPage(driver);
        managePage = new ManagePage(driver);
        accountPage = new NewAccountPage(driver);
        customerPage = new NewCustomerPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
