package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.*;

public class Base {
	//driver and browser setup
	static protected WebDriver driver;
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.get("https://www.policybazaar.com");
		Reporter.log("Browser launching", true);
	}
	public void launchBrowserUsingPropertyFile() throws IOException {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utility.readDataFromPropertyFile("url"));
		Reporter.log("Launching browser",true);
		
	}
    public void closeBrowser() {
    	driver.quit();
    	Reporter.log("closing Browser", true);
    }
}
