package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.MainPage;
import poms.LoginPage;
public class LogInTest {
	WebDriver driver = null;
	LoginPage LoginPage = null;

	 public LogInTest(WebDriver driver) throws InterruptedException
	    {
	    	this.driver = driver; 
	    	this.LoginPage = new LoginPage(driver);
	    }
	public void testPageLoaded() throws Exception
	    {
	       if (LoginPage.verifyPageIsLoaded() )
	       {
	    	   System.out.println("testpage is not loaded");
	    	   MainPage.takeSnapShot(driver, "D:\\JAVA\\Screenshots\\testpageloaded_test.png");
	     	   	throw new Exception("page not loaded !!!");
	       }
	       else
	       {
	    	   System.out.println("Sign in Page  loaded!!!");
	       }
	    }
	public void testValidUser() throws Exception {
		// TODO Auto-generated method stub
		 boolean value = LoginPage.loginValidUser("mngr533412", "amyteha");

		   Thread.sleep(3000);
		   if (! value )
	        {
			   MainPage.takeSnapShot(driver, "D:\\JAVA\\Screenshots\\validUser_test.png");
	            throw new Exception("Valid User Test Failed !!!");
	        }
	        else
	        { 
	        	LoginPage.clicklogin();
	            System.out.println("\nValid User Test Passed ");
	        }
	}

	 
}
