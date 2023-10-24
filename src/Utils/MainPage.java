package Utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Testcases.LogInTest;

public class MainPage {

	public static void TextField(WebElement element) {
     String inputText = element.getAttribute("value");
        
		if( inputText != null ) 
		{
			for(int i=0; i<inputText.length(); i++) 
			{
                element.sendKeys(Keys.BACK_SPACE);
            }
		}
			
	}
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception
	{
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile=new File(fileWithPath);

		FileUtils.copyFile(SrcFile, DestFile);
	}
	

}
