package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {
    private WebDriver driver;
    private By cusName =By.name("name");
    private By genderMale = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]");
    private By genderFemail = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]");
    private By dob = By.name("dob");
    private By address = By.name("addr");
    private By city = By.name("city");
    private By state = By.name("state");
    private By pin = By.name("pinno");
    private By phone = By.name("telephoneno");
    private By email = By.name("emailid");
    private By password = By.name("password");
    private By submitBtn = By.name("sub");
    private By resetBtn = By.name("res");
    public NewCustomerPage(WebDriver driver){
        this.driver = driver;
    }
    public void setCusName(String cusName) {
        driver.findElement(this.cusName).sendKeys(cusName);
    }
    public void setGender(String gender) {
        if(gender.equals("male"))
            driver.findElement(this.genderMale).click();
        else if (gender.equals("female"))
            driver.findElement(this.genderFemail).click();
    }
    public void setDob(String dob) {
        driver.findElement(this.dob).sendKeys(dob);
    }
    public void setAddress(String address) {
        driver.findElement(this.address).sendKeys(address);
    }
    public void setCity(String city) {
        driver.findElement(this.city).sendKeys(city);
    }
    public void setState(String state) {
        driver.findElement(this.state).sendKeys(state);
    }
    public void setPin(String pin) {
        driver.findElement(this.pin).sendKeys(pin);
    }
    public void setPhone(String phone) {
        driver.findElement(this.phone).sendKeys(phone);
    }
    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }
    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }
    public void clickSubmitButton() {
        driver.findElement(submitBtn).click();
    }
    public void clickResetButton() {
        driver.findElement(resetBtn).click();
    }
    public  boolean isClearForm(){
        String name = driver.findElement(this.cusName).getText();
        String dob = driver.findElement(this.dob).getText();
        String addr = driver.findElement(this.address).getText();
        String city = driver.findElement(this.city).getText();
        String state = driver.findElement(this.state).getText();
        if(name.isEmpty() || dob.isEmpty() || addr.isEmpty() || city.isEmpty() || state.isEmpty())
            return true;
        return false;
    }
    public void acceptJSAlert(){
        driver.switchTo().alert().accept();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
}
