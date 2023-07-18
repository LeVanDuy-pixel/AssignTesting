package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagePage {
    private WebDriver driver;
    private By welcomeAlert = By.tagName("marquee");
    private By createAccountMessage = By.xpath("//*[@id=\"account\"]/tbody/tr[1]/td/p");
    private By createCustomerMessage = By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p");

    private By logoutArea = By.linkText("Log out");
    private By newAccountArea = By.linkText("New Account");
    private By newCustomerArea = By.linkText("New Customer");
    public ManagePage(WebDriver driver){
        this.driver = driver;
    }
    public String getWelcomeText(){
        return driver.findElement(welcomeAlert).getText();
    }
    public String getCreateAccountMessage(){
        return driver.findElement(createAccountMessage).getText();
    }
    public String getCreateCustomerMessage() {
        return driver.findElement(createCustomerMessage).getText();
    }
    public void clickLogoutArea(){
        driver.findElement(logoutArea).click();
    }
    public void clickNewAccountArea(){
        driver.findElement(newAccountArea).click();
    }
    public void clickNewCustomerArea(){
        driver.findElement(newCustomerArea).click();
    }
    public void acceptJSAlert(){
        driver.switchTo().alert().accept();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
}
