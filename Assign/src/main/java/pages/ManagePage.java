package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagePage {
    private WebDriver driver;
    private By welcomeAlert = By.tagName("marquee");
    private By logoutArea = By.linkText("Log out");
    public ManagePage(WebDriver driver){
        this.driver = driver;
    }
    public String getWelcomeText(){
        return driver.findElement(welcomeAlert).getText();
    }
    public void clickLogoutArea(){
        driver.findElement(logoutArea).click();
    }
    public void acceptJSAlert(){
        driver.switchTo().alert().accept();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

}
