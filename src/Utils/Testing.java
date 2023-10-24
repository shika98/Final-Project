package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Testcases.LogInTest;
import Testcases.Test_accPage;
import Testcases.Test_customerPage;

public class Testing {

	public static void main(String[] args) throws Exception {

        try {
        	 System.setProperty("webdriver.chrome.driver", "./chromedriver-win64/chromedriver.exe"); 
        	WebDriver driver = new ChromeDriver();
        	//WebDriver driver = new FirefoxDriver();
            LogInTest testSignIn = new LogInTest(driver);
            testSignIn.testPageLoaded();
            testSignIn.testValidUser();
            Test_customerPage  NewPage = new Test_customerPage(driver);
            
            driver.navigate().refresh();
            NewPage.verifyPageIsLoaded();
            NewPage.mandatory_fields();           
            NewPage.valid_Data();
            
            Test_accPage  AccPage = new Test_accPage(driver);
            AccPage.MissingAccountType();
            AccPage.testResetForm();
            AccPage.AccValidData();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception or add more specific error handling.
        }
        
      
}
	}



