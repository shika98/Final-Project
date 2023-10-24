package Testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.MainPage;
import poms.Add_customer;
import poms.add_account;

public class Test_accPage {
	private static WebDriver driver = null;
	add_account addAccountPage = null;
	
	public Test_accPage(WebDriver driver) throws InterruptedException {
		this.driver = driver; 
    	this.addAccountPage = new add_account(driver);
	}
	public void AccValidData() throws Exception  {
		

        addAccountPage.selectCustomer("71377");
        addAccountPage.selectAccountType("Savings");
        addAccountPage.enterInitialDeposit("1000");
        addAccountPage.clickSubmit();
        WebElement text = driver.findElement(By.xpath("//p[text()='Account Generated Successfully!!!']"));
        if (text.isDisplayed()) {
            System.out.println("Account Generated Successfully!!!");
        } else {
        	System.out.println("invali details");
        	 MainPage.takeSnapShot(driver, "D:\\JAVA\\Screenshots\\invalid_test.png");
	     	   	throw new Exception("invali details!!!");
          

        }
	}
        public void MissingAccountType() throws Exception 
        {
        	addAccountPage.Widget1();
        addAccountPage.selectCustomer("71377");
        addAccountPage.enterInitialDeposit("");
        addAccountPage.clickSubmit();
        String errorMessage = addAccountPage.getErrorMessage();
        if (errorMessage.contains("Please fill all fields")) {
            System.out.println("Error message is displayed for empty fields.");
            MainPage.takeSnapShot(driver, "D:\\JAVA\\Screenshots\\Errormessag.png");
        } else {
            System.out.println("Error message is not displayed for empty fields.");
      
            
        }
        }
        
    public void testResetForm() throws IOException {
		 addAccountPage.selectCustomer("71377");
		addAccountPage.selectAccountType("Savings");
		addAccountPage.enterInitialDeposit("1000");
        addAccountPage.clickReset();
        System.out.println("\nall fields are empty.");
       
    }

   
	
	

    }

