package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountPage {
    private WebDriver driver;
    private By cusId =By.name("cusid");
    private By accType = By.name("selaccount");
    private By initDeposit = By.name("inideposit");
    private By submitBtn = By.name("button2");
    private By resetBtn = By.name("reset");
    public NewAccountPage(WebDriver driver){
        this.driver = driver;
    }
    public void setCusId(String id){
        driver.findElement(cusId).sendKeys(id);
    }
    public String getCusId(){
       return driver.findElement(cusId).getAttribute("value");
    }
    public void setAccType(String type){
        driver.findElement(accType).sendKeys(type);
    }
    public void setInitDeposit(String deposit){
        driver.findElement(initDeposit).sendKeys(deposit);
    }
    public void clickSubmitButton() {
        driver.findElement(submitBtn).click();
    }
    public void clickResetButton() {
        driver.findElement(resetBtn).click();
    }
    public void acceptJSAlert(){
        driver.switchTo().alert().accept();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
}
