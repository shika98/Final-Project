package Testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.MainPage;
import poms.Add_customer;

public class Test_customerPage {
	private static WebDriver driver = null;
    Add_customer addCustomerPage = null;	
	
  //Constructor
    public Test_customerPage(WebDriver driver) throws InterruptedException
    {
    	this.driver = driver; 
    	this.addCustomerPage = new Add_customer(driver);
    }
    public void verifyPageIsLoaded() throws Exception 
	  {
    	addCustomerPage.Widget();
	    System.out.print("\nTitle = " + driver.getTitle());
		    
	    if (driver.getTitle().equals("Guru99 Bank New Customer Entry Page")) 
	    {
	      System.out.println("\nThis is the customer entry page " + driver.getCurrentUrl());
	      
	    }
	    else {
	    	 System.out.println("\nThis is not the correct page");
	    	 MainPage.takeSnapShot(driver, "\"D:\\JAVA\\Screenshots\\customerpagenotloaded.png");
	            throw new Exception("This is not the correct page !!!");
	    }
        
	  }

    public void valid_Data() throws Exception 
    {
    	
         addCustomerPage.enterDateOfBirth("27/07/1988");
         addCustomerPage.enterAddress("chennai");
         addCustomerPage.enterCity("Madaras");
         addCustomerPage.enterState("Tn");
         addCustomerPage.enterPin("785488");
         addCustomerPage.enterMobileNumber("2268865845");
         addCustomerPage.enterEmail("karthikkaidi@hotmail.com");
         addCustomerPage.enterPassword("jothika31");
         addCustomerPage.clickSubmit();
         
         // Verify the success message
         WebElement Message = driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']"));
         if (Message.isDisplayed()) {
             System.out.println("Customer Registered Successfully!!!");
         } else {
        	 Alert alert = driver.switchTo().alert(); 

             String alertMessage1= driver.switchTo().alert().getText(); 
             System.out.println(alertMessage1); 
             Thread.sleep(5000);
             alert.accept();
             System.out.println("Customer Registeration unSuccessfull!!!");
             MainPage.takeSnapShot(driver, "D:\\JAVA\\Screenshots\\registration unscuccessfull_test.png");
	     	   	throw new Exception("Registeration unSuccessful!!!");
             
         }
        
    }
  public void mandatory_fields() throws Exception {
    	 addCustomerPage.enterCustomerName("rolex");
         addCustomerPage.selectGender("male");
         addCustomerPage.clickSubmit();
         Alert alert = driver.switchTo().alert(); 

         String alertMessage= driver.switchTo().alert().getText(); 
         System.out.println(alertMessage); 
         Thread.sleep(5000);
         alert.accept();
         MainPage.takeSnapShot(driver, "D:\\JAVA\\Screenshots\\fieldmissing_test.png");
      
     
    }
	
}
 



