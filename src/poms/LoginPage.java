package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.MainPage;

public class LoginPage {
	 public WebDriver driver;

	  public LoginPage(WebDriver driver) throws InterruptedException
	  {
		  this.driver=driver;
		  String url = "https://demo.guru99.com/v4";
		  driver.get(url);
		  System.out.print("\n Now loading " + url);
		  Thread.sleep(2000);
	  }
	   
	  private By UserID = By.xpath("//input[@name='uid']");

	 private By Password = By.xpath("//input[@name='password']");
	 private By Login = By.xpath("//input[@name='btnLogin']");

	 private By Reset = By.xpath("//input[@name='btnReset']");
	// private By Page_Success = By.xpath("//tbody/tr/td/marquee[@class='heading3' and contains(text(),'Guru99 Bank')]");
	
	
	  public boolean verifyPageIsLoaded() 
	  {
	    System.out.print("\nTitle = " + driver.getTitle());
		    
	    if (driver.getTitle().equals(" Guru99 Bank Home Page ")) 
	    {
	      System.out.println("This is not the login page" + driver.getCurrentUrl());
	    }
	    else {
	    	 System.out.println("This is the correct page");
	    }
		return false;
        
	  }
	  public boolean loginValidUser(String userName, String password) throws InterruptedException 
		{
		  MainPage.TextField(driver.findElement(UserID));
	  		driver.findElement(UserID).sendKeys(userName);
	  		
	  		MainPage.TextField(driver.findElement(Password));
	  		driver.findElement(Password).sendKeys(password);
				return true;
		}

		public void clickReset() {
		    driver.findElement(Reset).click();
		}
		public void clicklogin() {
		    driver.findElement(Login).click();
		}
}
