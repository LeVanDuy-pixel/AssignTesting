package base;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ManagePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginpage;
    protected ManagePage managePage;
    @BeforeEach
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver","ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
        loginpage = new LoginPage(driver);
        managePage = new ManagePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
