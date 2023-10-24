package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Add_customer {
	protected WebDriver driver;
	
  private By New_Customer = By.linkText("New Customer");
  private By customername = By.xpath("//input[@type='text']");

  private By male = By.xpath("//input[@value='m']");

  private By Female = By.xpath("//input[@value='f']");
  private By dateOfBirthField = By.xpath("//input[@id='dob']");
  private By Address = By.xpath("//textarea[@name='addr']");
  private By city  = By.xpath("//input[@name='city']");
  private By state  = By.xpath("//input[@name='state']");
  private By pin  = By.xpath("//input[@name='pinno']");
  private By MobileNo  = By.xpath("//input[@name='telephoneno']");
  private By email  = By.xpath("//input[@name='emailid']");
  private By Password  = By.xpath("//input[@name='password']");
  private By submit  = By.xpath("//input[@type='submit']");
  private By reset  = By.xpath("//input[@type='reset']");
  private By closeButton = By.xpath("//*[@id=\"dismiss-button\"]");

  public Add_customer(WebDriver driver) throws InterruptedException
  {
    this.driver = driver;
  }
  
public void Widget() {
        driver.findElement(New_Customer).click();
}
public void Ads() {
    driver.findElement(closeButton).click();
}



public void enterCustomerName(String name) {
    driver.findElement(customername).sendKeys(name);
}

public void selectGender(String gender) {
    if (gender.equalsIgnoreCase("male")) {
        driver.findElement(male).click();
    } else {
        driver.findElement(Female).click();
    }
}

public void enterDateOfBirth(String dob) {
    driver.findElement(dateOfBirthField).sendKeys(dob);
}

public void enterAddress(String address) {
    driver.findElement(Address).sendKeys(address);
}

public void enterCity(String cityname) {
    driver.findElement(city).sendKeys(cityname);
}

public void enterState(String statename) {
    driver.findElement(state).sendKeys(statename);
}

public void enterPin(String pinNo) {
    driver.findElement(pin).sendKeys(pinNo);
}

public void enterMobileNumber(String mobileNumber) {
    driver.findElement(MobileNo).sendKeys(mobileNumber);
}

public void enterEmail(String emailAdd) {
    driver.findElement(email).sendKeys(emailAdd);
}

public void enterPassword(String password) {
    driver.findElement(Password).sendKeys(password);
}

public void clickSubmit() {
    driver.findElement(submit).click();
}

public void clickReset() {
    driver.findElement(reset).click();
}
}