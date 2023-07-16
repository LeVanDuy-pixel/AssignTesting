package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userName =By.name("uid");
    private By password = By.name("password");
    private By loginButton = By.name("btnLogin");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUserName(String name){
        driver.findElement(userName).sendKeys(name);
    }
    public void setPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void acceptJSAlert(){
        driver.switchTo().alert().accept();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
    public void Login(){
        driver.findElement(userName).sendKeys("mngr512467");
        driver.findElement(password).sendKeys("sejEtug");
        driver.findElement(loginButton).click();
    }
}
