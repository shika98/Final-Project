package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class add_account {
	private WebDriver driver;
    private By customerSelect = By.xpath("//input[@name='cusid']");
    private By accountTypeSelect = By.xpath("//select[@name='selaccount']");
    private By initialDepositInput = By.xpath("//input[@name='inideposit']");
    private By submitButton = By.xpath("//input[@name='button2']");
    private By ResetButton = By.xpath("//input[@name='reset']");
    private By page =By.linkText("New Account");
    private By errorMessage = By.xpath("//label[@id='message19']");
    
    public add_account(WebDriver driver) throws InterruptedException
    {
      this.driver = driver;
    }
    
    public void Widget1() throws InterruptedException {
    	Thread.sleep(5000);
        driver.findElement(page).click();
        driver.navigate().refresh();
        driver.findElement(page).click();
}
    public void selectCustomer(String customerId) {
        driver.findElement(customerSelect).sendKeys(customerId);
    }

    public void selectAccountType(String accountType) {
        driver.findElement(accountTypeSelect).sendKeys(accountType);
        Select Country =new Select(driver.findElement(accountTypeSelect));
 	   Country.selectByValue("Savings");
    }

    public void enterInitialDeposit(String amount) {
        driver.findElement(initialDepositInput).sendKeys(amount);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

	public void clickReset() {
		driver.findElement(ResetButton).click();
	}
	public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
